package io.github.runkang10.paperbuildtools.generator.properties

import kotlinx.serialization.Serializable

@Serializable
data class DependencyCategory(
    val bootstrap: Map<String, PluginDependency>? = null,
    val server: Map<String, PluginDependency>? = null
)
