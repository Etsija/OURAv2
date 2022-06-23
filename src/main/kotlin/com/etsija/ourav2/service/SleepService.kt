package com.etsija.ourav2.service

import com.etsija.ourav2.network.SleepDataSource
import com.etsija.ourav2.domain.model.Sleep
import org.springframework.stereotype.Service

@Service
class SleepService(private val dataSource: SleepDataSource) {

    fun getAll(): Collection<Sleep> = dataSource.retrieveAll()
}