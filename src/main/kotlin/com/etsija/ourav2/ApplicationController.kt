package com.etsija.ourav2

import com.etsija.ourav2.controller.SleepController
import com.etsija.ourav2.service.ActivityService
import com.etsija.ourav2.service.ReadinessService
import com.etsija.ourav2.service.SleepService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class ApplicationController(
    private val readinessService: ReadinessService,
    private val activityService: ActivityService,
    private val sleepService: SleepService) {

    @GetMapping("/index")
    fun home(model: Model): String {

        val readinesses = readinessService.getAll()
        val activities = activityService.getAll()
        val sleeps = sleepService.getAll()
        model.addAttribute("readinesses", readinesses)
        model.addAttribute("activities", activities)
        model.addAttribute("sleeps", sleeps)
        return "index"
    }

    @GetMapping("/activity")
    fun activity(): String {
        return "/activity/index"
    }

    @GetMapping("/readiness")
    fun readiness(): String {
        return "/readiness/index"
    }

    @GetMapping("/sleep")
    fun sleep(): String {
        return "/sleep/index"
    }

    @GetMapping("/settings")
    fun settings(): String {
        return "/settings/index"
    }

}