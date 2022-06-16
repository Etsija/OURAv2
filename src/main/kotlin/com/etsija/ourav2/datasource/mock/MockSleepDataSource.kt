package com.etsija.ourav2.datasource.mock

import com.etsija.ourav2.datasource.SleepDataSource
import com.etsija.ourav2.model.Sleep
import org.springframework.stereotype.Repository

@Repository
class MockSleepDataSource : SleepDataSource {

    val sleeps = listOf(
        Sleep("2020-06-09", "2022-06-02T21:57:31+03:00", "2022-06-03T07:17:31+03:00", 16.75, 90, 63.22, 57, 93),
        Sleep("2020-06-10", "2022-06-02T21:57:31+03:00", "2022-06-03T07:17:31+03:00", 16.75, 90, 63.22, 57, 93),
        Sleep("2020-06-11", "2022-06-02T21:57:31+03:00", "2022-06-03T07:17:31+03:00", 16.75, 90, 63.22, 57, 93)
    )

    override fun retrieveAll(): Collection<Sleep> = sleeps
}