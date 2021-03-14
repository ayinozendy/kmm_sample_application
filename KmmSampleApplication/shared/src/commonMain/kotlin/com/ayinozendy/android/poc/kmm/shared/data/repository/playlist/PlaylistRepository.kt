package com.ayinozendy.android.poc.kmm.shared.data.repository.playlist

import com.ayinozendy.android.poc.kmm.shared.model.Playlist

interface PlaylistRepository {
    suspend fun fetchPlaylist()
    suspend fun getPlaylist(): Playlist
}
