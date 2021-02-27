package com.ayinozendy.android.poc.kmm.shared.data.service

import io.ktor.client.*

expect class ApiClientFactory {
    companion object {
        fun createClient(): HttpClient
    }
}
