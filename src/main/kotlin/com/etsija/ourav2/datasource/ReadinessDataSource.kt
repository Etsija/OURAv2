package com.etsija.ourav2.datasource

import com.etsija.ourav2.model.Readiness

interface ReadinessDataSource {

    fun retrieveReadinessAll(): Collection<Readiness>
}