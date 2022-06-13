package com.etsija.ourav2.datasource.network


import com.etsija.ourav2.datasource.SleepDataSource
import com.etsija.ourav2.datasource.network.dto.SleepList
import com.etsija.ourav2.helpers.HttpHelpers
import com.etsija.ourav2.model.Sleep
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpEntity
import org.springframework.http.HttpMethod
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Repository
import org.springframework.web.client.RestTemplate
import java.io.IOException

@Repository("network_sleep")
class NetworkSleepDataSource(
    @Autowired private val restTemplate: RestTemplate
) : SleepDataSource {

    override fun retrieveAll(): Collection<Sleep> {

        val headers = HttpHelpers.getHttpHeaders()
        val request: HttpEntity<SleepList> = HttpEntity<SleepList>(headers)
        val response: ResponseEntity<SleepList> =
            restTemplate.exchange(
                HttpHelpers.SLEEP_URL + HttpHelpers.getStartEnd(30),
                HttpMethod.GET,
                request,
                SleepList::class.java
            )

        return response.body?.sleep
            ?: throw IOException("Could not fetch sleep data from OURA API")    }
}