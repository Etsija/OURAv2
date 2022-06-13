package com.etsija.ourav2.datasource.network


import com.etsija.ourav2.datasource.ReadinessDataSource
import com.etsija.ourav2.datasource.network.dto.ReadinessList
import com.etsija.ourav2.model.Readiness
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

@Repository("network_readiness")
class NetworkReadinessDataSource(
    @Autowired private val restTemplate: RestTemplate
) : ReadinessDataSource {

    val url: String = "https://api.ouraring.com/v1/readiness"
    val token: String = "QY5M3RS6V2AWLHMXXR4HAGJVXNSJRNPL"
    val z: ZoneId = ZoneId.of("Europe/Helsinki")
    val endDate: String = LocalDate.now(z).toString()
    // Show data for last 30 days
    val startDate: String = LocalDate.now(z).minusDays(30).toString()
    val headers: HttpHeaders = HttpHeaders()

    override fun retrieveAll(): Collection<Readiness> {

        headers.set("Host", "api.ouraring.com")
        headers.setBearerAuth(token)

        val request: HttpEntity<ReadinessList> = HttpEntity<ReadinessList>(headers)
        val response: ResponseEntity<ReadinessList> =
            restTemplate.exchange(
                url + "?start=" + startDate + "&end=" + endDate,
                HttpMethod.GET,
                request,
                ReadinessList::class.java
            )

        return response.body?.readiness
            ?: throw IOException("Could not fetch readiness data from OURA API")
    }
}