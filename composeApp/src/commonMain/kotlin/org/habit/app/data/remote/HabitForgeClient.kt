package org.habit.app.data.remote

import io.ktor.client.HttpClient
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.DEFAULT
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.habit.app.utils.Constant.TIMEOUT

object HabitForgeClient {
    private val client = HttpClient {
        install(ContentNegotiation){
            json(
                Json {
                    isLenient = true
                    ignoreUnknownKeys = true
                }
            )
        }

        install(Logging){
            logger = Logger.DEFAULT
            level = LogLevel.ALL
        }
        install(HttpTimeout){
            requestTimeoutMillis = TIMEOUT
            socketTimeoutMillis = TIMEOUT
            connectTimeoutMillis = TIMEOUT
        }
    }
}