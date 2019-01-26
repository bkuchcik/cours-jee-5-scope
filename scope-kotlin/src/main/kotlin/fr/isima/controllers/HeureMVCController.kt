package fr.isima.controllers

import fr.isima.runOnValue
import fr.isima.service.Hour
import fr.isima.views.toHtml
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import javax.inject.Provider

@Controller
@RequestMapping("/heure")
class HeureMVCController @Autowired constructor(private val hourProvider: Provider<Hour>) {

    @GetMapping
    @ResponseBody
    fun heure() = hourProvider.runOnValue { toHtml() }

}
