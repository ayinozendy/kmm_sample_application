package com.ayinozendy.android.poc.kmm.shared.data.repository.video

import com.ayinozendy.android.poc.kmm.shared.data.mapper.VideoDbModelMapper
import com.ayinozendy.android.poc.kmm.shared.model.Video
import shared.persistence.VideoDbItemQueries

class VideoRepositoryImpl(
    private val videoDao: VideoDbItemQueries
) : VideoRepository {
    override fun getVideo(int: Int): Video? {
        val videoItem = videoDao.findById(int.toString()).executeAsOneOrNull()
        videoItem?.let {
            return VideoDbModelMapper.fromSqlDelightEntityToModel(videoItem)
        }

        return null
    }
}
