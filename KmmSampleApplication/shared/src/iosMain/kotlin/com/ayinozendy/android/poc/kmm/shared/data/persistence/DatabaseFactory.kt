package com.ayinozendy.android.poc.kmm.shared.data.persistence

import shared.persistence.KmmAppDatabase

actual class DatabaseFactory {
    actual fun createDatabase(): KmmAppDatabase {
        val driver = DriverFactory().createDriver()
        return KmmAppDatabase(driver)
    }
}
