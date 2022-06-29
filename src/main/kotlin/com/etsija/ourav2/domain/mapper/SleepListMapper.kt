package com.etsija.ourav2.domain.mapper

import com.etsija.ourav2.domain.model.Activity
import com.etsija.ourav2.domain.model.Sleep
import com.etsija.ourav2.network.response.ActivityResponse
import com.etsija.ourav2.network.response.SleepResponse

object SleepListMapper {

    fun buildFrom(response: Collection<SleepResponse>): Collection<Sleep> {

        val thisMap: Collection<Sleep> = response.map {sleep ->
            SleepMapper.buildFrom(sleep)
        }
        return thisMap
    }
}