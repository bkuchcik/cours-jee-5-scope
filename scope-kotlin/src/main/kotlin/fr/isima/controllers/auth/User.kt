package fr.isima.controllers.auth

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.context.annotation.SessionScope

import javax.servlet.http.HttpSession


open class User(open val name: String)

@Configuration
class UserConfiguration {


    @Bean
    @SessionScope
    @Autowired
    fun user(session: HttpSession) = session.getAttribute("user") as User
}
