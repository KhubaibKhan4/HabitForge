package org.habit.app.domain.usecase

sealed class ResultState<out T> {
    object LOADING : ResultState<Nothing>()
    data class SUCCESS<T>(val response: T) : ResultState<T>()
    data class ERROR(val error: Throwable) : ResultState<Nothing>()
}