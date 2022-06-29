package com.etsija.ourav2.network.response

data class ActivityResponse2(
    val activity: Collection<Activity>
) {
    data class Activity(
        val average_met: Double,
        val cal_active: Int,
        val cal_total: Int,
        val class_5min: String,
        val daily_movement: Int,
        val day_end: String,
        val day_start: String,
        val high: Int,
        val inactive: Int,
        val inactivity_alerts: Int,
        val low: Int,
        val medium: Int,
        val met_1min: List<Double>,
        val met_min_high: Int,
        val met_min_inactive: Int,
        val met_min_low: Int,
        val met_min_medium: Int,
        val non_wear: Int,
        val rest: Int,
        val rest_mode_state: Int,
        val score: Int,
        val score_meet_daily_targets: Int,
        val score_move_every_hour: Int,
        val score_recovery_time: Int,
        val score_stay_active: Int,
        val score_training_frequency: Int,
        val score_training_volume: Int,
        val steps: Int,
        val summary_date: String,
        val target_calories: Int,
        val target_km: Double,
        val target_miles: Double,
        val timezone: Int,
        val to_target_km: Double,
        val to_target_miles: Double,
        val total: Int
    )
}