package com.ayinozendy.android.poc.kmm.shared.data.mapper

import com.ayinozendy.android.poc.kmm.shared.model.Video
import shared.persistence.VideoDbItem

class VideoDbModelMapper {
    companion object {
        fun toSqlDelightEntity(video: Video): VideoDbItem {
            return VideoDbItem(
                id = video.id.toString(),
                title = video.title,
                author = video.author,
                description = video.description,
                videoUrl = video.videoUrl,
                thumbnailUrl = video.thumbnailUrl
            )
        }

        fun fromSqlDelightEntityToModel(videoItem: VideoDbItem): Video {
            return Video(
                id = videoItem.id.toInt(),
                title = videoItem.title,
                author = videoItem.author,
                description = videoItem.description,
                videoUrl = videoItem.videoUrl,
                thumbnailUrl = videoItem.thumbnailUrl
            )
        }

        fun fromSqlDelightEntityToModels(videoEntityEntities: List<VideoDbItem>): List<Video> {
            return videoEntityEntities.map {
                fromSqlDelightEntityToModel(it)
            }
        }
    }
}
