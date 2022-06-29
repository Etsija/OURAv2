package com.etsija.ourav2.network

import com.etsija.ourav2.domain.model.Activity
import com.etsija.ourav2.network.dto.ActivityList

interface ActivityDataSource {
    fun retrieveAll(): Collection<Activity>
}