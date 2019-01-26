package fr.isima.controllers

import fr.isima.runOnValue
import fr.isima.service.Hour
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.inject.Provider

@RestController
@RequestMapping("/rest/heure")
class HeureRestController @Autowired constructor(private val hourProvider: Provider<Hour>) {

    @GetMapping
    fun heure() = hourProvider.runOnValue { copy() }
}

