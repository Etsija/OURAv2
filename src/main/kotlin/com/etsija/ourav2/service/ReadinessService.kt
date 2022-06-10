package com.etsija.ourav2.service


import com.etsija.ourav2.datasource.ReadinessDataSource
import com.etsija.ourav2.model.Readiness
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service

@Service
class ReadinessService(@Qualifier("network_readiness") private val dataSource: ReadinessDataSource) {

    fun getAll(): Collection<Readiness> = dataSource.retrieveAll()
}