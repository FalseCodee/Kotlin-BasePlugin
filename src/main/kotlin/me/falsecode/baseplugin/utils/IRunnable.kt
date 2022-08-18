package me.falsecode.baseplugin.utils

fun interface IRunnable<T> {
    fun execute(t: T)
}