package com.etsija.ourav2.service


import com.etsija.ourav2.network.ActivityDataSource
import com.etsija.ourav2.domain.model.Activity
import org.springframework.stereotype.Service

@Service
class ActivityService(private val dataSource: ActivityDataSource) {

    fun getAll(): Collection<Activity> = dataSource.retrieveAll()
}