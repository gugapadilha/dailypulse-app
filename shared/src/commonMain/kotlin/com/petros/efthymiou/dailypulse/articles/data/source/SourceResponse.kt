package com.petros.efthymiou.dailypulse.articles.data.source

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SourceResponse(
    @SerialName("sources")
    val sources: List<SourcesRaw>
)
