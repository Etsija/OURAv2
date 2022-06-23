package com.etsija.ourav2.domain.model
import com.fasterxml.jackson.annotation.JsonProperty

data class Activity(

    @JsonProperty("summary_date")
    val summaryDate: String,

    @JsonProperty("target_calories")
    val calTarget: Int,

    @JsonProperty("cal_active")
    val calActive: Int,

    @JsonProperty("cal_total")
    val calTotal: Int,

    @JsonProperty("target_km")
    val kmTarget: Int,

    @JsonProperty("to_target_km")
    val kmToTarget: Double,

    @JsonProperty("steps")
    val steps: Int,

    @JsonProperty("daily_movement")
    val dailyMovement: Int,

    @JsonProperty("score")
    val score: Int
)