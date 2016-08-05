package com.webwalker.plugin;

import com.sun.tools.attach.VirtualMachine;
import com.webwalker.agent.MyAgent;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

import java.io.File;
import java.lang.management.ManagementFactory;

/**
 * Created by xujian on 2016/8/5.
 */
public class ApmPlugin implements Plugin<Project> {
    @Override
    public void apply(Project project) {
        String nameOfRunningVM = ManagementFactory.getRuntimeMXBean().getName();
        int p = nameOfRunningVM.indexOf('@');
        String pid = nameOfRunningVM.substring(0, p);
        try {
            String jarFilePath = MyAgent.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath();
            jarFilePath = new File(jarFilePath).getCanonicalPath();
            VirtualMachine vm = VirtualMachine.attach(pid);
            vm.loadAgent(jarFilePath, System.getProperty("openapm.agentArgs"));
            vm.detach();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
