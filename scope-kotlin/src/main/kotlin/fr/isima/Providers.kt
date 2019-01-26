package fr.isima

import javax.inject.Provider

fun <T, R> Provider<T>.runOnValue(toRun: T.() -> R) = get()!!.toRun()