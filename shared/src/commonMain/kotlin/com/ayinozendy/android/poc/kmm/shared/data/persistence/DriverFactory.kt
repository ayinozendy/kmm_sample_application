package com.ayinozendy.android.poc.kmm.shared.data.persistence

import com.squareup.sqldelight.db.SqlDriver

expect class DriverFactory {
    fun createDriver() : SqlDriver
}
