package com.etsija.ourav2.controller

import com.etsija.ourav2.model.Readiness
import com.etsija.ourav2.service.ReadinessService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

//@RestController
//@RequestMapping("/api/readiness")
@Controller
class ReadinessController(private val service: ReadinessService) {

    @GetMapping("/api/readiness")
    fun getAll(): Collection<Readiness> = service.getAll()

    @GetMapping("/table_readiness")
    fun getTable(model: Model): String {

        var readinesses = service.getAll()

        model.addAttribute("readinesses", readinesses)
        return "common/table_readiness"
    }
}