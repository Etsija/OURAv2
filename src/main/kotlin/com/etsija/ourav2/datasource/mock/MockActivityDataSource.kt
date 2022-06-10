package com.etsija.ourav2.datasource.mock

import com.etsija.ourav2.datasource.ActivityDataSource
import com.etsija.ourav2.model.Activity
import org.springframework.stereotype.Repository

@Repository
class MockActivityDataSource : ActivityDataSource {

    val activities = listOf(
        Activity("2020-05-31", 400, 8000, 70),
        Activity("2020-06-01", 500, 9000, 75),
        Activity("2020-06-02", 600, 10000, 80)
    )

    override fun retrieveAll(): Collection<Activity> = activities
}