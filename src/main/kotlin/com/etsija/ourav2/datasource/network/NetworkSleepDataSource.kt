package com.etsija.ourav2.datasource.network


import com.etsija.ourav2.datasource.SleepDataSource
import com.etsija.ourav2.datasource.network.dto.SleepList
import com.etsija.ourav2.model.Sleep
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

@Repository("network_sleep")
class NetworkSleepDataSource(
    @Autowired private val restTemplate: RestTemplate
) : SleepDataSource {

    val url: String = "https://api.ouraring.com/v1/sleep"
    val token: String = "QY5M3RS6V2AWLHMXXR4HAGJVXNSJRNPL"
    val z: ZoneId = ZoneId.of("Europe/Helsinki")
    val endDate: String = LocalDate.now(z).toString()
    // Show data for last 30 days
    val startDate: String = LocalDate.now(z).minusDays(30).toString()
    val headers: HttpHeaders = HttpHeaders()

    override fun retrieveAll(): Collection<Sleep> {

        headers.set("Host", "api.ouraring.com")
        headers.setBearerAuth(token)

        val request: HttpEntity<SleepList> = HttpEntity<SleepList>(headers)
        val response: ResponseEntity<SleepList> =
            restTemplate.exchange(
                url + "?start=" + startDate + "&end=" + endDate,
                HttpMethod.GET,
                request,
                SleepList::class.java
            )

        return response.body?.sleep
            ?: throw IOException("Could not fetch sleep data from OURA API")    }
}