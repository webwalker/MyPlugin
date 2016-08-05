package com.webwalker.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project

class DateAndTimePlugin implements Plugin<Project> {
    void apply(Project project) {

        project.extensions.create("dateAndTime", DateAndTimePluginExtension)

        project.task('showTime') << {
            println "Current time is " + new Date().format(project.dateAndTime.timeFormat)
        }

        project.tasks.create('showDate') << {
            println "Current date is " + new Date().format(project.dateAndTime.dateFormat)
        }
    }
}

class DateAndTimePluginExtension {
    String timeFormat = "yyyy/MM/dd HH:mm:ss.SSS"
    String dateFormat = "yyyy-MM-dd"
}