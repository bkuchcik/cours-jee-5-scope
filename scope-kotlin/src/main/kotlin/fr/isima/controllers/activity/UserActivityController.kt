package fr.isima.controllers.activity

import fr.isima.runOnValue
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import javax.inject.Provider

@Controller
@RequestMapping("/activity")
class UserActivityController @Autowired
constructor(
        private val userActivityCounterProvider: Provider<UserActivityCounter>
) {

    @GetMapping
    @ResponseBody
    fun userActivityCounter() = this.userActivityCounterProvider.runOnValue { numberOfRequest }
}
