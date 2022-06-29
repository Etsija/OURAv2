package com.etsija.ourav2.network

import com.etsija.ourav2.domain.mapper.ActivityListMapper
import com.etsija.ourav2.domain.mapper.ReadinessListMapper
import com.etsija.ourav2.network.dto.ReadinessList
import com.etsija.ourav2.helpers.HttpHelpers
import com.etsija.ourav2.domain.model.Readiness
import com.etsija.ourav2.network.response.ReadinessListResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpEntity
import org.springframework.http.HttpMethod
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Repository
import org.springframework.web.client.RestTemplate
import java.io.IOException

@Repository()
class NetworkReadinessDataSource(
    @Autowired private val restTemplate: RestTemplate
) : ReadinessDataSource {

    override fun retrieveAll(): Collection<Readiness> {

        val headers = HttpHelpers.getHttpHeaders()
        val request: HttpEntity<ReadinessListResponse> = HttpEntity<ReadinessListResponse>(headers)
        val response: ResponseEntity<ReadinessListResponse> =
            restTemplate.exchange(
                HttpHelpers.READINESS_URL + HttpHelpers.getStartEnd(HttpHelpers.HISTORY_DAYS),
                HttpMethod.GET,
                request,
                ReadinessListResponse::class.java
            )

        return response.body?.let { ReadinessListMapper.buildFrom(it.readiness) }
            ?: throw IOException("Could not fetch readiness data from OURA API")
    }
}