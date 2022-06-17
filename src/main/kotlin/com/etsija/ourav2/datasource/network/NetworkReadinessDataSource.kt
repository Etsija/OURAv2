package com.etsija.ourav2.datasource.network

import com.etsija.ourav2.datasource.ReadinessDataSource
import com.etsija.ourav2.datasource.network.dto.ReadinessList
import com.etsija.ourav2.helpers.HttpHelpers
import com.etsija.ourav2.model.Readiness
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpEntity
import org.springframework.http.HttpMethod
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Repository
import org.springframework.web.client.RestTemplate
import java.io.IOException

@Repository("network_readiness")
class NetworkReadinessDataSource(
    @Autowired private val restTemplate: RestTemplate
) : ReadinessDataSource {

    override fun retrieveAll(): Collection<Readiness> {

        val headers = HttpHelpers.getHttpHeaders()
        val request: HttpEntity<ReadinessList> = HttpEntity<ReadinessList>(headers)
        val response: ResponseEntity<ReadinessList> =
            restTemplate.exchange(
                HttpHelpers.READINESS_URL + HttpHelpers.getStartEnd(HttpHelpers.HISTORY_DAYS),
                HttpMethod.GET,
                request,
                ReadinessList::class.java
            )

        return response.body?.readiness
            ?: throw IOException("Could not fetch readiness data from OURA API")
    }
}