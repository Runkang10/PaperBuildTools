package io.github.runkang10.paperbuildtools

import io.github.runkang10.paperbuildtools.generator.PluginGenerator
import org.gradle.api.Plugin
import org.gradle.api.Project

@Suppress("UNUSED")
class PaperBuildTools : Plugin<Project> {
    override fun apply(project: Project) {
        PluginGenerator(project)
    }
}
