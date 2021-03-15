package com.ayinozendy.android.poc.kmm.shared.data.repository.video

import shared.persistence.KmmAppDatabase

class VideoRepositoryFactory(
    private val database: KmmAppDatabase
) {
    fun create(): VideoRepository {
        return VideoRepositoryImpl(database.videoDbItemQueries)
    }
}
