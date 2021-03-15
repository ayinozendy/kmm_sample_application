package com.ayinozendy.android.poc.kmm.shared.data.persistence

import android.content.Context
import shared.persistence.KmmAppDatabase

actual class DatabaseFactory(private val context: Context) {
    actual fun createDatabase(): KmmAppDatabase {
        val driver = DriverFactory(context).createDriver()
        return KmmAppDatabase(driver)
    }
}
