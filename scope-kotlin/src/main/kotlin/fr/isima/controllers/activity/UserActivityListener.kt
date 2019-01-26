package fr.isima.controllers.activity

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component
import org.springframework.web.context.support.ServletRequestHandledEvent

import javax.inject.Provider

@Component
class UserActivityListener @Autowired
constructor(
    private val userActivityCounterProvider: Provider<UserActivityCounter>
) {

    @EventListener
    fun handleEvent(e: ServletRequestHandledEvent) {
        if (e.requestUrl.contains("heure")) {
            this.userActivityCounterProvider.get().incrementAndGet()
        }
    }
}
