package com.webwalker.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project;

class CustomPlugin implements Plugin<Project> {
    void apply(Project project) {
        project.task('myTask') << {
            println "Hi this is micky's plugin"
        }
        project.task('customTask', type: MyCustomTask)

        project.extensions.create('myArgs', MyCustomPluginExtension)
        project.task('customTask1', type: MyCustomParamsTask)

        project.myArgs.extensions.create('nestArgs', MyNestPluginExtension)
        project.task('customTask2', type: MyCustomNestParamsTask)
    }
}

class MyNestPluginExtension {
    def receiver = "Kate Zhou"
    def email = "KateZhou@gmail.com"
}

class MyCustomPluginExtension {
    def message = "From MyCustomPluginExtention"
    def sender = "MyCustomPluin"
}