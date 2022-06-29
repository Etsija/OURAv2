package com.etsija.ourav2.domain.mapper

import com.etsija.ourav2.domain.model.Activity
import com.etsija.ourav2.network.response.ActivityResponse

object ActivityMapper {

    fun buildFrom(response: ActivityResponse): Activity {

        val kmToTargetFlipped = response.to_target_km * -1.0

        return Activity(
            summaryDate = response.summary_date,
            calTarget = response.target_calories,
            calActive = response.cal_active,
            calTotal = response.cal_total,
            kmTarget = response.target_km,
            kmToTarget = kmToTargetFlipped,
            steps = response.steps,
            dailyMovement = response.daily_movement,
            score = response.score
        )
    }
}