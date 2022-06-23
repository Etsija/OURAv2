package com.etsija.ourav2.network

import com.etsija.ourav2.domain.model.Activity

interface ActivityDataSource {

    fun retrieveAll(): Collection<Activity>
}