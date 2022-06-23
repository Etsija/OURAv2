package com.etsija.ourav2.domain.model
import com.fasterxml.jackson.annotation.JsonProperty

data class Readiness(

    @JsonProperty("summary_date")
    val summaryDate: String,

    @JsonProperty("score_activity_balance")
    val scoreActivityBalance: Int,

    @JsonProperty("score_hrv_balance")
    val scoreHRVBalance: Int,

    @JsonProperty("score_recovery_index")
    val scoreRecoveryIndex: Int,

    @JsonProperty("score_resting_hr")
    val scoreRestingHR: Int,

    @JsonProperty("score_sleep_balance")
    val scoreSleepBalance: Int,

    @JsonProperty("score_temperature")
    val scoreTemperature: Int,

    @JsonProperty("score")
    val score: Int
    )