package com.etsija.ourav2.network


import com.etsija.ourav2.domain.mapper.ReadinessListMapper
import com.etsija.ourav2.domain.mapper.SleepListMapper
import com.etsija.ourav2.network.dto.SleepList
import com.etsija.ourav2.helpers.HttpHelpers
import com.etsija.ourav2.domain.model.Sleep
import com.etsija.ourav2.network.response.SleepListResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpEntity
import org.springframework.http.HttpMethod
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Repository
import org.springframework.web.client.RestTemplate
import java.io.IOException

@Repository()
class NetworkSleepDataSource(
    @Autowired private val restTemplate: RestTemplate
) : SleepDataSource {

    override fun retrieveAll(): Collection<Sleep> {

        val headers = HttpHelpers.getHttpHeaders()
        val request: HttpEntity<SleepListResponse> = HttpEntity<SleepListResponse>(headers)
        val response: ResponseEntity<SleepListResponse> =
            restTemplate.exchange(
                HttpHelpers.SLEEP_URL + HttpHelpers.getStartEnd(HttpHelpers.HISTORY_DAYS),
                HttpMethod.GET,
                request,
                SleepListResponse::class.java
            )

        return response.body?.let { SleepListMapper.buildFrom(it.sleep) }
            ?: throw IOException("Could not fetch sleep data from OURA API")
    }
}