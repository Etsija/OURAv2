package com.etsija.ourav2.domain.mapper

import com.etsija.ourav2.domain.model.Activity
import com.etsija.ourav2.domain.model.Readiness
import com.etsija.ourav2.network.response.ActivityResponse
import com.etsija.ourav2.network.response.ReadinessResponse

object ReadinessMapper {
    fun buildFrom(response: ReadinessResponse): Readiness {

        // Any calculations needed here

        return Readiness(
            summaryDate = response.summary_date,
            scoreActivityBalance = response.score_activity_balance,
            scoreHRVBalance = response.score_hrv_balance,
            scoreRecoveryIndex = response.score_recovery_index,
            scoreRestingHR = response.score_resting_hr,
            scoreSleepBalance = response.score_sleep_balance,
            scoreTemperature = response.score_temperature,
            score = response.score
        )
    }
}