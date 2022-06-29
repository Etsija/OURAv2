package com.etsija.ourav2.domain.mapper

import com.etsija.ourav2.domain.model.Readiness
import com.etsija.ourav2.domain.model.Sleep
import com.etsija.ourav2.network.response.ReadinessResponse
import com.etsija.ourav2.network.response.SleepResponse

object SleepMapper {

    fun buildFrom(response: SleepResponse): Sleep {

        // Any calculations needed here

        return Sleep(
            summaryDate = response.summary_date,
            bedtimeStart = response.bedtime_start,
            bedtimeEnd = response.bedtime_end,
            breathAverage = response.breath_average,
            efficiency = response.efficiency,
            hrAverage = response.hr_average,
            hrLowest = response.hr_lowest,
            score = response.score
        )
    }
}