package com.etsija.ourav2

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class ApplicationController {

    @GetMapping("/index")
    fun home(): String {
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