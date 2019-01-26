package fr.isima.controllers.auth

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

import javax.servlet.http.HttpSession

@Controller
@RequestMapping("/auth")
class AuthController {

    @GetMapping("{user}")
    @ResponseBody
    fun auth(@PathVariable user: String, httpSession: HttpSession): String {
        if (user == "Henri") {
            httpSession.setAttribute("user", User(user))
            return "ok"
        }
        return "ko"
    }
}
