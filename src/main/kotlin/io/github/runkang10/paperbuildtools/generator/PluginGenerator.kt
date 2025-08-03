package io.github.runkang10.paperbuildtools.generator

import org.gradle.api.Project
import org.gradle.api.Task
import org.gradle.api.tasks.SourceSetContainer
import org.gradle.api.tasks.TaskProvider
import org.gradle.kotlin.dsl.get
import org.gradle.kotlin.dsl.the

class PluginGenerator(project: Project) {
    init {
        val extension = project.extensions.create("paperConfig", PluginExtension::class.java)
        val task = project.tasks.register("generatePaperConfig", PluginConfig::class.java) {
            pluginName.set(extension.pluginName)
            pluginVersion.set(extension.pluginVersion)
            main.set(extension.main)
            apiVersion.set(extension.apiVersion)
            pluginDescription.set(extension.pluginDescription)
            hasOpenClassloader.set(extension.hasOpenClassloader)
            load.set(extension.load)
            foliaSupported.set(extension.foliaSupported)
            authors.set(extension.authors)
            contributors.set(extension.contributors)
            website.set(extension.website)
            prefix.set(extension.prefix)
            dependencies.set(extension.dependencies)
        }

        process(project, task)
    }

    private fun <T : Task> process(project: Project, task: TaskProvider<T>) {
        project.tasks.named("processResources").configure {
            dependsOn(task)
        }
        project.the(SourceSetContainer::class)["main"].resources {
            srcDir(project.layout.buildDirectory.dir("generated-resources"))
        }
    }
}