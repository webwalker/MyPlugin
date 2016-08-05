package com.webwalker.plugin

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

class MyCustomNestParamsTask extends DefaultTask {
    @TaskAction
    void output() {
        println "Sender is ${project.myArgs.sender} \nmessage: ${project.myArgs.message}"
        println "Receiver is ${project.myArgs.nestArgs.receiver} \nemail: ${project.myArgs.nestArgs.email}"
    }
}