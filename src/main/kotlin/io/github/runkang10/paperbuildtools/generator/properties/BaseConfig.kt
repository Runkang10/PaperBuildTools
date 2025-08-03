package io.github.runkang10.paperbuildtools.generator.properties

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BaseConfig(
    val name: String,
    val version: String,
    val main: String,
    @SerialName("api-version") val apiVersion: String,
    val description: String? = null,
    @SerialName("has-open-classloader") val hasOpenClassloader: Boolean? = null,
    val load: String? = null,
    @SerialName("folia-supported")
    val foliaSupported: Boolean? = null,
    val authors: List<String>? = null,
    val contributors: List<String>? = null,
    val website: String? = null,
    val prefix: String? = null,
    val dependencies: DependencyCategory? = null
)
