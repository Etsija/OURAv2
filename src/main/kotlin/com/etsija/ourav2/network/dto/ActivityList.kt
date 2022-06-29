package com.etsija.ourav2.network.dto

import com.etsija.ourav2.domain.model.Activity
import com.etsija.ourav2.network.response.ActivityResponse

data class ActivityList(
    val activity: Collection<Activity>
)