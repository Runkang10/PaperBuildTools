package io.github.runkang10.paperbuildtools.generator.properties

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PluginDependency(
    val load: LoadType = LoadType.OMIT,
    val required: Boolean = true,
    @SerialName("join-classpath")
    val joinClasspath: Boolean = true
)
