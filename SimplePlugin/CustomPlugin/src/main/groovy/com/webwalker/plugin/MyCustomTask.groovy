package com.webwalker.plugin

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

class MyCustomTask extends DefaultTask {
    @TaskAction
    void output() {
        println "Hello this is my custom task output"
    }
}