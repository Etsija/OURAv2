package com.etsija.ourav2.model
import com.fasterxml.jackson.annotation.JsonProperty

data class Sleep(

    @JsonProperty("summary_date")
    val summaryDate: String,

    @JsonProperty("bedtime_start")
    val bedtimeStart: String,

    @JsonProperty("bedtime_end")
    val bedtimeEnd: String,

    @JsonProperty("efficiency")
    val efficiency: Int,

    @JsonProperty("hr_lowest")
    val hrLowest: Int,

    @JsonProperty("score")
    val score: Int
)