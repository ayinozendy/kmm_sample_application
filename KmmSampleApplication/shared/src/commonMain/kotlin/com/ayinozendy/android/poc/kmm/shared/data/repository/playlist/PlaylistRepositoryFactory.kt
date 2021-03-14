package com.ayinozendy.android.poc.kmm.shared.data.repository.playlist

import io.ktor.client.*
import shared.persistence.KmmAppDatabase

class PlaylistRepositoryFactory(
    private val database: KmmAppDatabase
) {
    fun create(): PlaylistRepository {
        return PlaylistRepositoryImpl(database.videoDbItemQueries)
    }
}

