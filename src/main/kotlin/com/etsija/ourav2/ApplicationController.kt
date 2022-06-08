package com.etsija.ourav2

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class ApplicationController {

    @GetMapping("/index")
    fun home(): String {
        return "index"
    }

    @GetMapping("/contact")
    fun contact(): String {
        return "pages-contact"
    }

}