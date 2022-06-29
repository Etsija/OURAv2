package com.etsija.ourav2.domain.mapper

import com.etsija.ourav2.domain.model.Activity
import com.etsija.ourav2.network.response.ActivityResponse

object ActivityListMapper {

    fun buildFrom(response: Collection<ActivityResponse>): Collection<Activity> {

        val thisMap: Collection<Activity> = response.map {activity ->
            ActivityMapper.buildFrom(activity)

        }
        return thisMap
    }

}