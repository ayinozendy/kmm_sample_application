package com.ayinozendy.android.poc.kmm.shared.data.service

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.http.*

actual class ApiClientFactory {
    actual companion object {
        actual fun createClient(): HttpClient {
            return HttpClient(CIO) {
                install(JsonFeature) {
                    serializer = KotlinxSerializer(kotlinx.serialization.json.Json {
                        prettyPrint = true
                        isLenient = true
                    })
                    accept(ContentType.Text.Plain)
                }
            }
        }
    }
}
