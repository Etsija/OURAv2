package com.etsija.ourav2.controller

import com.etsija.ourav2.model.Readiness
import com.etsija.ourav2.service.ReadinessService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/readiness")
class ReadinessController(private val service: ReadinessService) {

    @GetMapping
    fun getReadinessAll(): Collection<Readiness> = service.getReadinessAll()
}