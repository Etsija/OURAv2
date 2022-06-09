package com.etsija.ourav2.model
import com.fasterxml.jackson.annotation.JsonProperty

data class Readiness(

    @JsonProperty("summary_date")
    val summaryDate: String,

    @JsonProperty("score")
    val score: Int
)