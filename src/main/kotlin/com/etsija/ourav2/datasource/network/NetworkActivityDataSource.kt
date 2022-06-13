package com.etsija.ourav2.datasource.network

import com.etsija.ourav2.datasource.ActivityDataSource
import com.etsija.ourav2.datasource.network.dto.ActivityList
import com.etsija.ourav2.model.Activity
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Repository
import org.springframework.web.client.RestTemplate
import java.io.IOException
import java.time.LocalDate
import java.time.ZoneId

@Repository("network_activity")
class NetworkActivityDataSource(
    @Autowired private val restTemplate: RestTemplate
) : ActivityDataSource {

    val url: String = "https://api.ouraring.com/v1/activity"
    val token: String = "QY5M3RS6V2AWLHMXXR4HAGJVXNSJRNPL"
    val z: ZoneId = ZoneId.of("Europe/Helsinki")
    val endDate: String = LocalDate.now(z).toString()
    // Show data for last 30 days
    val startDate: String = LocalDate.now(z).minusDays(30).toString()
    val headers: HttpHeaders = HttpHeaders()

    override fun retrieveAll(): Collection<Activity> {

        headers.set("Host", "api.ouraring.com")
        headers.setBearerAuth(token)

        val request: HttpEntity<ActivityList> = HttpEntity<ActivityList>(headers)
        val response: ResponseEntity<ActivityList> =
            restTemplate.exchange(
                url + "?start=" + startDate + "&end=" + endDate,
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