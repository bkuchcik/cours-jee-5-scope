package fr.isima.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.context.annotation.ApplicationScope
import org.springframework.web.context.annotation.RequestScope
import java.io.IOException
import java.util.*

@Configuration
class HourConfiguration {

    @Bean
    @ApplicationScope
    @Throws(IOException::class)
    fun hourProperties() = Properties()
        .run {
            load(HourConfiguration::class.java.getResourceAsStream("/hour.properties"))
                .run { HourPattern(getProperty("format.date.heure.courante")) }
        }

    @Bean
    @RequestScope
    @Autowired
    fun hour(hourGenerator: HourGenerator) = hourGenerator.nowWithStandardFormat()
}