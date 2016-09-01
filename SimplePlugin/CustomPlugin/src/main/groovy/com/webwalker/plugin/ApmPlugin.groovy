package com.webwalker.plugin

import org.gradle.api.DefaultTask
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.tasks.TaskAction

import java.util.logging.Logger

class ApmPlugin implements Plugin<Project> {
    private static Logger logger;

    @Override
    void apply(Project target) {
        //logger = target.logger;
        //target.logger.info("Apm plugin loaded.");

        project.task('apmInstrumentTask', type: ApmInstrumentTask);
        project.task('apmDeinstrumentTask', type: ApmDeinstrumentTask);
    }
}

class ApmTask extends DefaultTask {
    String getJarFilePath() {

    }

    String injectAgent() {

    }
}

class ApmInstrumentTask extends ApmTask {
    ApmInstrumentTask() {
    }


}

class ApmDeinstrumentTask extends ApmTask {
    @TaskAction
    void output() {
        println "Hello this is my custom task output"
    }
}