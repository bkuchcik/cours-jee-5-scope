package fr.isima.service

import org.springframework.stereotype.Component
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

const val FORMAT_STANDARD_DATE = "HH:mm:ss 'le' dd/MM/yyyy"

@Component
class HourGenerator {
    fun nowWithStandardFormat(): Hour =
        LocalDateTime.now().run {
            Hour(this, DateTimeFormatter.ofPattern(FORMAT_STANDARD_DATE).format(this))
        }
}

//for spring compatibility we must declare classes as open
open class Hour internal constructor(open val unformatted: LocalDateTime, open val formatted: String) {
    fun copy(unfo: LocalDateTime = unformatted, form: String = formatted) = Hour(unformatted = unfo, formatted = form)
}

open class HourPattern internal constructor(val hourPattern: String)