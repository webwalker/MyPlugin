import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

class MyCustomParamsTask extends DefaultTask {
    @TaskAction
    void output() {
        println "Sender is ${project.myArgs.sender} \nmessage: ${project.myArgs.message}"
    }
}