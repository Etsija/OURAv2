package com.etsija.ourav2.domain.model

data class Activity(

    val summaryDate: String = "",
    val calTarget: Int = 0,
    val calActive: Int = 0,
    val calTotal: Int = 0,
    val kmTarget: Double = 0.0,
    var kmToTarget: Double = 0.0,
    val steps: Int = 0,
    val dailyMovement: Int = 0,
    val score: Int = 0
)