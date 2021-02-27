package com.ayinozendy.android.poc.kmm.shared.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Playlist(
    @SerialName("play_list") val videos: List<@Serializable Video>
)
