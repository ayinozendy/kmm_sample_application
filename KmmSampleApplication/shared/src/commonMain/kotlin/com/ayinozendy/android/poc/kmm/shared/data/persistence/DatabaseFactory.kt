package com.ayinozendy.android.poc.kmm.shared.data.persistence

import shared.persistence.KmmAppDatabase

expect class DatabaseFactory {
    fun createDatabase() : KmmAppDatabase
}
