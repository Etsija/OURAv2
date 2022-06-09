package com.etsija.ourav2.datasource.network


import com.etsija.ourav2.datasource.SleepDataSource
import com.etsija.ourav2.datasource.network.dto.SleepList
import com.etsija.ourav2.model.Sleep
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Repository
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.getForEntity
import java.io.IOException

@Repository("network_sleep")
class NetworkSleepDataSource(
    @Autowired private val restTemplate: RestTemplate
) : SleepDataSource {

    override fun retrieveSleepAll(): Collection<Sleep> {
        val response: ResponseEntity<SleepList> =
            restTemplate.getForEntity("https://api.ouraring.com/v1/sleep?access_token=QY5M3RS6V2AWLHMXXR4HAGJVXNSJRNPL")

        return response.body?.sleep
            ?: throw IOException("Could not fetch sleep data from OURA API")    }
}