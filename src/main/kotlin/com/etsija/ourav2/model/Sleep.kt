package com.etsija.ourav2.model
import com.fasterxml.jackson.annotation.JsonProperty

data class Sleep(

    @JsonProperty("summary_date")
    val summaryDate: String,

    @JsonProperty("bedtime_start")
    val bedtimeStart: String,

    @JsonProperty("bedtime_end")
    val bedtimeEnd: String,

    @JsonProperty("breath_average")
    val breathAverage: Double,

    @JsonProperty("efficiency")
    val efficiency: Int,

    @JsonProperty("hr_average")
    val hrAverage: Double,
    @JsonProperty("hr_lowest")
    val hrLowest: Int,

    @JsonProperty("score")
    val score: Int
)