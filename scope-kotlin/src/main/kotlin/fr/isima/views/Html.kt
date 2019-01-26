package fr.isima.views

import kotlinx.html.HTML
import kotlinx.html.html
import kotlinx.html.stream.appendHTML
import java.io.StringWriter

fun html(renderer: HTML.() -> Unit) =
        StringWriter().run {
            appendHTML().html(block = renderer)
            buffer.toString()
        }
