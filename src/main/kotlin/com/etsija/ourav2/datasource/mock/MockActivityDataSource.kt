package com.etsija.ourav2.datasource.mock

import com.etsija.ourav2.datasource.ActivityDataSource
import com.etsija.ourav2.model.Activity
import org.springframework.stereotype.Repository

@Repository
class MockActivityDataSource : ActivityDataSource {

    val activities = listOf(
        Activity("2020-06-09", 450, 863, 3179, 8, -7.2, 15272, 15321, 97),
        Activity("2020-06-01", 450, 500, 2300, 8, -0.5, 8000, 8500, 90),
        Activity("2020-06-02", 450, 500, 2300, 8, -0.5, 8000, 8500, 90)
    )

    override fun retrieveAll(): Collection<Activity> = activities
}