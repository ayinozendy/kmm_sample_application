package com.ayinozendy.android.poc.kmm.shared.data.repository.video

import com.ayinozendy.android.poc.kmm.shared.model.Video

interface VideoRepository {
    fun getVideo(int: Int): Video?
}
