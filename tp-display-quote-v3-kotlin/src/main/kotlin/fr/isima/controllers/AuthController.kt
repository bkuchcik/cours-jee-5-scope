package fr.isima.controllers

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class AuthController {

    @RequestMapping("/login")
    fun login(): String = "loginPage"
}
