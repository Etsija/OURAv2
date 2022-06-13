package com.etsija.ourav2.helpers

import org.springframework.http.HttpHeaders
import java.time.LocalDate
import java.time.ZoneId

class HttpHelpers {
    companion object {

        fun getHttpHeaders(): HttpHeaders {
            val headers = HttpHeaders()
            headers.set("Host", "api.ouraring.com")
            headers.setBearerAuth(TOKEN)
            return headers
        }

        fun getToday(): String {
            val z: ZoneId = ZoneId.of("Europe/Helsinki")
            return LocalDate.now(z).toString()
        }

        fun getTodayMinus(days: Long): String {
            val z: ZoneId = ZoneId.of("Europe/Helsinki")
            return LocalDate.now(z).minusDays(days).toString()
        }

        fun getStartEnd(days: Long): String {
            return "?start=" + getTodayMinus(days) + "&end=" + getToday()
        }

        const val TOKEN = "QY5M3RS6V2AWLHMXXR4HAGJVXNSJRNPL"
        const val ACTIVITY_URL = "https://api.ouraring.com/v1/activity"
        const val READINESS_URL = "https://api.ouraring.com/v1/readiness"
        const val SLEEP_URL = "https://api.ouraring.com/v1/sleep"
    }
}