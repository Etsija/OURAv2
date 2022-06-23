package com.etsija.ourav2.network.dto

import com.etsija.ourav2.domain.model.Activity

data class ActivityList(
    val activity: Collection<Activity>
)