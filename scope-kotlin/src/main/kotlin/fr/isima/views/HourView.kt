package fr.isima.views

import fr.isima.service.Hour
import kotlinx.html.*

fun Hour.toHtml(): String = html {
    head {
        script {
            type = "text/javascript"
            src = "/js/jquery-2.2.0.js"
        }
        script {
            type = "text/javascript"
            src = "/js/bootstrap.min.js"
        }
        link {
            rel = "stylesheet"
            type = "text/css"
            href = "/css/bootstrap-theme.min.css"
        }
        link {
            rel = "stylesheet"
            type = "text/css"
            href = "/css/bootstrap.min.css"
        }
    }
    body {
        div {
            classes = setOf("container")
            div {
                classes = setOf("jumbotron")
                h1 { +"Heure courante" }
                p {
                    classes = setOf("lead")
                    style = "\"height: 150px"
                    +" Cette page a été générée à "
                    span {
                        id = "heureCourante"
                        +formatted
                    }
                }
            }
        }
        script {
            type = "text/javascript"
            src = "/js/custom/heure-courante.js"
        }
    }

}