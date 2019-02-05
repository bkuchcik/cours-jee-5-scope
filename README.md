# Cours sur les scopes 

* [Le cours](https://docs.google.com/presentation/d/e/2PACX-1vTybYTmWpi5Cuw2MU9DYU6AvmVttDBWWDH7VdXiyrob7hW17pAa86ClJ6GxJsiahltNVJr8iNvynX3V/pub?start=false&loop=false&delayms=3000)
* [Le tp](https://docs.google.com/document/d/e/2PACX-1vSS5LpgPSgnE7sRaGBNGyxU0PQD2eBibZ18PtrR0VnJhhNNV1zWjc3FOdMiqJtj2CPB4PxhwdZ3JAyz/pub)

Pour vous aider avec Spring Security suivez le [guide de paramétrage](https://docs.spring.io/spring-security/site/docs/5.0.0.RELEASE/reference/htmlsingle/)

## Avertissement

Dans le build, j'ai ajouté un dépendance à Spring Security qui n'est disponible que lorsque vous utiliser les tp.

Le nom du module doit contenir tp-display-quote pour obtenir cette dépendance (vous le verrez dans la correction).

# Activer spring security

Pour activer Spring Security il faut rajouter la dépendance suivante :
```kotlin
implementation("org.springframework.boot:spring-boot-starter-security")
```

Voici une classe de configuration de base de Spring Security en Java
```java

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/resources/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .successHandler((request, response, authentication) -> {
                    request.getSession().setAttribute("username", authentication.getName());
                    response.sendRedirect("/main");
                }).permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser(User.withDefaultPasswordEncoder().username("grut").password("APass").roles("USER"))
                .withUser(User.withDefaultPasswordEncoder().username("admin").password("admin").roles("ADMIN"));
    }
}
```

La version équivalante en Kotlin
```kotlin

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/resources/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .successHandler((request, response, authentication) -> {
                    request.getSession().setAttribute("username", authentication.getName());
                    response.sendRedirect("/main");
                }).permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser(User.withDefaultPasswordEncoder().username("grut").password("APass").roles("USER"))
                .withUser(User.withDefaultPasswordEncoder().username("admin").password("admin").roles("ADMIN"));
    }
}
```

Ces classes vous permettront de gérer la sécurité avec SpringSecurity, de créer des uses
