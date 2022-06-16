package com.etsija.ourav2.datasource.mock

import com.etsija.ourav2.datasource.ReadinessDataSource
import com.etsija.ourav2.model.Readiness
import org.springframework.stereotype.Repository

@Repository
class MockReadinessDataSource : ReadinessDataSource {

    val readinesses = listOf(
        Readiness("2020-06-09", 61, 93, 93, 96, 85, 93, 87),
        Readiness("2020-06-10", 61, 93, 93, 96, 85, 93, 87),
        Readiness("2020-06-11", 61, 93, 93, 96, 85, 93, 87)
    )

    override fun retrieveAll(): Collection<Readiness> = readinesses
}