package fr.isima.controllers.auth

import fr.isima.runOnValue
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

import javax.inject.Provider

@Controller
@RequestMapping("/withAuth")
class AuthentifiedController @Autowired
constructor(private val userProvider: Provider<User>) {

    @GetMapping
    @ResponseBody
    fun user() = userProvider.runOnValue { name }
}
