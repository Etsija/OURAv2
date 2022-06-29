package com.etsija.ourav2.network.response

data class ReadinessResponse(
    val period_id: Int,
    val rest_mode_state: Int,
    val score: Int,
    val score_activity_balance: Int,
    val score_hrv_balance: Int,
    val score_previous_day: Int,
    val score_previous_night: Int,
    val score_recovery_index: Int,
    val score_resting_hr: Int,
    val score_sleep_balance: Int,
    val score_temperature: Int,
    val summary_date: String
)