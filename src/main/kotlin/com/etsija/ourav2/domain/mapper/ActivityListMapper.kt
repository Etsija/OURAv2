package com.etsija.ourav2.domain.mapper

import com.etsija.ourav2.domain.model.Activity
import com.etsija.ourav2.network.dto.ActivityList
import com.etsija.ourav2.network.response.ActivityResponse
import com.etsija.ourav2.network.response.ActivityResponse2

object ActivityListMapper {

    fun buildFrom(response: ActivityResponse2): ActivityList {

        val thisMap: List<Activity> = response.activity.map {activity ->
            ActivityMapper.buildFrom(activity)

        }
        return ActivityList(thisMap)
    }

}