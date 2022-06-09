package com.etsija.ourav2.controller

import com.etsija.ourav2.model.Activity
import com.etsija.ourav2.service.ActivityService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/activity")
class ActivityController(private val service: ActivityService) {

    @GetMapping
    fun getActivityAll(): Collection<Activity> = service.getActivityAll()
}