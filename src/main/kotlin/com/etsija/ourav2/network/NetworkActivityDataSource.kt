package com.etsija.ourav2.network

import com.etsija.ourav2.domain.mapper.ActivityListMapper
import com.etsija.ourav2.domain.model.Activity
import com.etsija.ourav2.helpers.HttpHelpers
import com.etsija.ourav2.network.response.ActivityListResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpEntity
import org.springframework.http.HttpMethod
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Repository
import org.springframework.web.client.RestTemplate
import java.io.IOException

@Repository()
class NetworkActivityDataSource(
    @Autowired private val restTemplate: RestTemplate
) : ActivityDataSource {

    override fun retrieveAll(): Collection<Activity> {

        val headers = HttpHelpers.getHttpHeaders()
        val request: HttpEntity<ActivityListResponse> = HttpEntity<ActivityListResponse>(headers)
        val response: ResponseEntity<ActivityListResponse> =
            restTemplate.exchange(
                HttpHelpers.ACTIVITY_URL + HttpHelpers.getStartEnd(HttpHelpers.HISTORY_DAYS),
                HttpMethod.GET,
                request,
                ActivityListResponse::class.java
            )

        //val response: ResponseEntity<ActivityList> =
        //    restTemplate.getForEntity("https://api.ouraring.com/v1/activity?access_token=QY5M3RS6V2AWLHMXXR4HAGJVXNSJRNPL")

        return response.body?.let { ActivityListMapper.buildFrom(it.activity) }
            ?: throw IOException("Could not fetch activity data from OURA API")
    }
}