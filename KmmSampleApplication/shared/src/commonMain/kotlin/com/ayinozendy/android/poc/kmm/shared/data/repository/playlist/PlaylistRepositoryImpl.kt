package com.ayinozendy.android.poc.kmm.shared.data.repository.playlist

import com.ayinozendy.android.poc.kmm.shared.data.mapper.VideoDbModelMapper
import com.ayinozendy.android.poc.kmm.shared.data.service.ApiClientFactory
import com.ayinozendy.android.poc.kmm.shared.model.Playlist
import io.ktor.client.request.*
import shared.persistence.VideoDbItemQueries

class PlaylistRepositoryImpl(
    private val videoDao: VideoDbItemQueries
) : PlaylistRepository {
    override suspend fun fetchPlaylist() {
        val client = ApiClientFactory.createClient()
        val newPlaylist = client.get<Playlist> {
            url(
                "https://gist.githubusercontent.com/" +
                        "ayinozendy/" +
                        "a1f7629d8760c0d9cd4a5a4f051d111c/" +
                        "raw/" +
                        "6ead19b28382af688e8b4426d2310f0468a2fb5f/playlist.json"
            )
        }

        if (newPlaylist.videos.isNullOrEmpty()) {
            throw Exception("Null Playlist")
        } else {
            saveNewPlaylist(newPlaylist)
        }
        client.close()
    }

    private fun saveNewPlaylist(newPlaylist: Playlist) {
        videoDao.deleteAll()
        newPlaylist.videos.forEach {
            videoDao.insertItem(VideoDbModelMapper.toSqlDelightEntity(it))
        }
    }

    override suspend fun getPlaylist(): Playlist {
        val playlist = retrievePlaylist()
        return if (playlist.videos.isNullOrEmpty()) {
            try {
                fetchPlaylist()
            } finally {
                //Do nothing
            }
            retrievePlaylist()
        } else {
            playlist
        }
    }

    private fun retrievePlaylist(): Playlist {
        val entities = videoDao.getAll()
        val videos = VideoDbModelMapper.fromSqlDelightEntityToModels(entities.executeAsList())
        return Playlist(videos)
    }
}
