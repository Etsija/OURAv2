package com.etsija.ourav2.datasource.network


import com.etsija.ourav2.datasource.ReadinessDataSource
import com.etsija.ourav2.datasource.network.dto.ReadinessList
import com.etsija.ourav2.model.Readiness
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Repository
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForEntity
import java.io.IOException

@Repository("network_readiness")
class NetworkReadinessDataSource(
    @Autowired private val restTemplate: RestTemplate
) : ReadinessDataSource {

    override fun retrieveReadinessAll(): Collection<Readiness> {
        val response: ResponseEntity<ReadinessList> =
            restTemplate.getForEntity("https://api.ouraring.com/v1/readiness?access_token=QY5M3RS6V2AWLHMXXR4HAGJVXNSJRNPL")

        return response.body?.readiness
            ?: throw IOException("Could not fetch readiness data from OURA API")
    }
}