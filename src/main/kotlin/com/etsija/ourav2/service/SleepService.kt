package com.etsija.ourav2.service

import com.etsija.ourav2.datasource.SleepDataSource
import com.etsija.ourav2.model.Sleep
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service

@Service
class SleepService(@Qualifier("network_sleep") private val dataSource: SleepDataSource) {

    fun getAll(): Collection<Sleep> = dataSource.retrieveAll()
}