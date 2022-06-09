package com.etsija.ourav2.datasource.mock

import com.etsija.ourav2.datasource.SleepDataSource
import com.etsija.ourav2.model.Sleep
import org.springframework.stereotype.Repository

@Repository
class MockSleepDataSource : SleepDataSource {

    val sleeps = listOf(
        Sleep("2020-06-02", "2022-06-02T21:57:31+03:00", "2022-06-03T07:17:31+03:00", 89, 55, 93),
        Sleep("2020-06-03", "2022-06-04T00:24:31+03:00", "2022-06-04T07:07:31+03:00", 89, 67, 79),
        Sleep("2020-06-04", "2022-06-05T02:40:31+03:00", "2022-06-05T10:46:31+03:00", 85, 64, 81),
    )

    override fun retrieveSleepAll(): Collection<Sleep> = sleeps
}