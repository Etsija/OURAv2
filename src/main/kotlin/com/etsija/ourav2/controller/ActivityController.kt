package com.etsija.ourav2.controller

import com.etsija.ourav2.domain.model.Activity
import com.etsija.ourav2.service.ActivityService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

//@RestController
//@RequestMapping("/api/activity")
@Controller
class ActivityController(private val service: ActivityService) {

    @GetMapping("/api/activity")
    fun getAll(): Collection<Activity> = service.getAll()

    @GetMapping("/table_activity")
    fun getTable(model: Model): String {

        val activities = service.getAll()

        model.addAttribute("activities", activities)
        return "activity/table_activity"
    }

    @GetMapping("/graph_activity")
    fun getGraph(model: Model): String {

        val activities = service.getAll()

        model.addAttribute("activities", activities)
        return "activity/graph_activity"
    }


}