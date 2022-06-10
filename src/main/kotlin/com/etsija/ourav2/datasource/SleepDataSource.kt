package com.etsija.ourav2.datasource

import com.etsija.ourav2.model.Sleep


interface SleepDataSource {

    fun retrieveAll(): Collection<Sleep>
}