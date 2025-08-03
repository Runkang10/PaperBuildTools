package io.github.runkang10.paperbuildtools.generator

import io.github.runkang10.paperbuildtools.generator.properties.DependencyCategory
import org.gradle.api.provider.ListProperty
import org.gradle.api.provider.Property
import org.gradle.api.tasks.Optional

interface PluginExtension {
    val pluginName: Property<String>
    val pluginVersion: Property<String>
    val main: Property<String>
    val apiVersion: Property<String>
    @get:Optional
    val pluginDescription: Property<String>
    @get:Optional
    val hasOpenClassloader: Property<Boolean>
    @get:Optional
    val load: Property<String>
    @get:Optional
    val foliaSupported: Property<Boolean>
    @get:Optional
    val authors: ListProperty<String>
    @get:Optional
    val contributors: ListProperty<String>
    @get:Optional
    val website: Property<String>
    @get:Optional
    val prefix: Property<String>
    @get:Optional
    val dependencies: Property<DependencyCategory>
}
