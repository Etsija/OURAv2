package com.etsija.ourav2.service


import com.etsija.ourav2.datasource.ActivityDataSource
import com.etsija.ourav2.model.Activity
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service

@Service
class ActivityService(@Qualifier("network_activity") private val dataSource: ActivityDataSource) {

    fun getAll(): Collection<Activity> = dataSource.retrieveAll()
}