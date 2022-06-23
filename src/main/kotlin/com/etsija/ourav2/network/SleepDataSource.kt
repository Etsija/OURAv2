package com.etsija.ourav2.network

import com.etsija.ourav2.domain.model.Sleep


interface SleepDataSource {

    fun retrieveAll(): Collection<Sleep>
}