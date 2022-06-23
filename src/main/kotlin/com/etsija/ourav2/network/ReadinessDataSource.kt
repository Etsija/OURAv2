package com.etsija.ourav2.network

import com.etsija.ourav2.domain.model.Readiness

interface ReadinessDataSource {

    fun retrieveAll(): Collection<Readiness>
}