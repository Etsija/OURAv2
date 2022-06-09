package com.etsija.ourav2.model
import com.fasterxml.jackson.annotation.JsonProperty

data class Activity(

    @JsonProperty("summary_date")
    val summaryDate: String,

    @JsonProperty("cal_total")
    val calTotal: Int,

    @JsonProperty("steps")
    val steps: Int,

    @JsonProperty("score")
    val score: Int
)