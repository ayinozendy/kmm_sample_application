package com.ayinozendy.android.poc.kmm.shared.data.persistence

import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver
import shared.persistence.KmmAppDatabase

actual class DriverFactory {
    actual fun createDriver(): SqlDriver {
        return NativeSqliteDriver(
            schema = KmmAppDatabase.Schema,
            name = "kmm_app_database"
        )
    }
}
