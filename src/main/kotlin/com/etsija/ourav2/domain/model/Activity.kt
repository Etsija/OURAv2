package com.etsija.ourav2.domain.model
import com.fasterxml.jackson.annotation.JsonProperty

data class Activity(

    @JsonProperty("summary_date")
    val summaryDate: String = "",

    @JsonProperty("target_calories")
    val calTarget: Int = 0,

    @JsonProperty("cal_active")
    val calActive: Int = 0,

    @JsonProperty("cal_total")
    val calTotal: Int = 0,

    @JsonProperty("target_km")
    val kmTarget: Double = 0.0,

    @JsonProperty("to_target_km")
    var kmToTarget: Double = 0.0,

    @JsonProperty("steps")
    val steps: Int = 0,

    @JsonProperty("daily_movement")
    val dailyMovement: Int = 0,

    @JsonProperty("score")
    val score: Int = 0
)