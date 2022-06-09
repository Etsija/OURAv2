package com.etsija.ourav2.controller

import com.etsija.ourav2.model.Sleep
import com.etsija.ourav2.service.SleepService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/sleep")
class SleepController(private val service: SleepService) {

    @GetMapping
    fun getSleepAll(): Collection<Sleep> = service.getSleepAll()
}