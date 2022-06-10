package com.etsija.ourav2.datasource.mock

import com.etsija.ourav2.datasource.ReadinessDataSource
import com.etsija.ourav2.model.Readiness
import org.springframework.stereotype.Repository

@Repository
class MockReadinessDataSource : ReadinessDataSource {

    val readinesses = listOf(
        Readiness("2020-05-31", 60),
        Readiness("2020-06-01", 65),
        Readiness("2020-06-02", 70)
    )

    override fun retrieveAll(): Collection<Readiness> = readinesses
}