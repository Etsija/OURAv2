package com.etsija.ourav2.service


import com.etsija.ourav2.network.ReadinessDataSource
import com.etsija.ourav2.domain.model.Readiness
import org.springframework.stereotype.Service

@Service
class ReadinessService(private val dataSource: ReadinessDataSource) {

    fun getAll(): Collection<Readiness> = dataSource.retrieveAll()
}