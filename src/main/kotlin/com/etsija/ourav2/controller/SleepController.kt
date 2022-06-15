package com.etsija.ourav2.controller

import com.etsija.ourav2.model.Sleep
import com.etsija.ourav2.service.SleepService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

//@RestController
//@RequestMapping("/api/sleep")
@Controller
class SleepController(private val service: SleepService) {

    @GetMapping("/api/sleep")
    fun getAll(): Collection<Sleep> = service.getAll()

    @GetMapping("/table_sleep")
    fun getTable(model: Model): String {

        var sleeps = service.getAll()

        model.addAttribute("sleeps", sleeps)
        return "sleep/table_sleep"
    }
}