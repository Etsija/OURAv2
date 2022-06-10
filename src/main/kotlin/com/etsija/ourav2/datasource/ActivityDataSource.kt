package com.etsija.ourav2.datasource

import com.etsija.ourav2.model.Activity

interface ActivityDataSource {

    fun retrieveAll(): Collection<Activity>
}