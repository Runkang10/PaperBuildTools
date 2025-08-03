package io.github.runkang10.paperbuildtools.generator

import com.charleskorn.kaml.Yaml
import com.charleskorn.kaml.YamlConfiguration
import io.github.runkang10.paperbuildtools.generator.properties.BaseConfig
import io.github.runkang10.paperbuildtools.generator.properties.DependencyCategory
import org.gradle.api.DefaultTask
import org.gradle.api.provider.ListProperty
import org.gradle.api.provider.Property
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.Optional
import org.gradle.api.tasks.TaskAction
import java.io.File

abstract class PluginConfig : DefaultTask() {
    @get:Input
    abstract val pluginName: Property<String>

    @get:Input
    abstract val pluginVersion: Property<String>

    @get:Input
    abstract val main: Property<String>

    @get:Input
    abstract val apiVersion: Property<String>

    @get:Input
    @get:Optional
    abstract val pluginDescription: Property<String>

    @get:Input
    @get:Optional
    abstract val hasOpenClassloader: Property<Boolean>

    @get:Input
    @get:Optional
    abstract val load: Property<String>

    @get:Input
    @get:Optional
    abstract val foliaSupported: Property<Boolean>

    @get:Input
    @get:Optional
    abstract val authors: ListProperty<String>

    @get:Input
    @get:Optional
    abstract val contributors: ListProperty<String>

    @get:Input
    @get:Optional
    abstract val website: Property<String>

    @get:Input
    @get:Optional
    abstract val prefix: Property<String>

    @get:Input
    @get:Optional
    abstract val dependencies: Property<DependencyCategory>

    private fun <T> optional(property: Property<T>) = property.orNull
    private fun <T> optionalList(property: ListProperty<T>) = if (!property.get().isEmpty()) property.get() else null

    @TaskAction
    fun execute() {
        val config = generate(
            BaseConfig(
                pluginName.get(),
                pluginVersion.get(),
                main.get(),
                apiVersion.get(),
                optional(pluginDescription),
                optional(hasOpenClassloader),
                optional(load),
                optional(foliaSupported),
                optionalList(authors),
                optionalList(contributors),
                optional(website),
                optional(prefix),
                optional(dependencies)
            )
        )
        saveConfig(config)
        println("✅ Successfully generated 'paper-plugin.yml' for ${project.name}!")
    }

    private fun generate(baseConfig: BaseConfig) =
        Yaml(
            configuration = YamlConfiguration(
                encodeDefaults = false,
                strictMode = true
            )
        )
            .encodeToString(BaseConfig.serializer(), baseConfig)

    private fun saveConfig(config: String) {
        val output = File(
            project.layout.buildDirectory
                .dir("generated-resources")
                .get()
                .asFile,
            "paper-plugin.yml"
        )
        output.parentFile.mkdirs()
        output.writeText(config)
    }
}