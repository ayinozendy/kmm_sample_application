package com.ayinozendy.android.poc.kmm.shared.data.persistence

import android.content.Context
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver
import shared.persistence.KmmAppDatabase

actual class DriverFactory(private val context: Context) {
    actual fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(
            schema = KmmAppDatabase.Schema,
            context = context,
            name = "kmm_app_database"
        )
    }
}
