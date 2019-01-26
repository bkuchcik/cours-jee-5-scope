package fr.isima.controllers.activity

import org.springframework.stereotype.Component
import org.springframework.web.context.annotation.SessionScope

import java.util.concurrent.atomic.AtomicInteger

@Component
@SessionScope
class UserActivityCounter {

    private val atomicInteger = AtomicInteger()

    val numberOfRequest: Int
        get() = atomicInteger.get()

    fun incrementAndGet(): Int = atomicInteger.incrementAndGet()

}
