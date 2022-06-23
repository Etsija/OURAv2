package com.etsija.ourav2.network

import com.etsija.ourav2.network.dto.ActivityList
import com.etsija.ourav2.helpers.HttpHelpers
import com.etsija.ourav2.domain.model.Activity
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
        val request: HttpEntity<ActivityList> = HttpEntity<ActivityList>(headers)
        val response: ResponseEntity<ActivityList> =
            restTemplate.exchange(
                HttpHelpers.ACTIVITY_URL + HttpHelpers.getStartEnd(HttpHelpers.HISTORY_DAYS),
                HttpMethod.GET,
                request,
                ActivityList::class.java
            )

        //val response: ResponseEntity<ActivityList> =
        //    restTemplate.getForEntity("https://api.ouraring.com/v1/activity?access_token=QY5M3RS6V2AWLHMXXR4HAGJVXNSJRNPL")

        return response.body?.activity
            ?: throw IOException("Could not fetch activity data from OURA API")
    }
}