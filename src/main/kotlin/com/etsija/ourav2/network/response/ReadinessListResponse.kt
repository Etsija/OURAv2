package com.etsija.ourav2.network.response

import com.etsija.ourav2.domain.model.Activity
import com.etsija.ourav2.network.response.ActivityResponse

data class ReadinessListResponse(
    val readiness: Collection<ReadinessResponse>
)