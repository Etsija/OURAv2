package com.etsija.ourav2.domain.mapper

import com.etsija.ourav2.domain.model.Activity
import com.etsija.ourav2.domain.model.Readiness
import com.etsija.ourav2.network.response.ActivityResponse
import com.etsija.ourav2.network.response.ReadinessResponse

object ReadinessListMapper {

    fun buildFrom(response: Collection<ReadinessResponse>): Collection<Readiness> {

        val thisMap: Collection<Readiness> = response.map {readiness ->
            ReadinessMapper.buildFrom(readiness)

        }
        return thisMap
    }
}