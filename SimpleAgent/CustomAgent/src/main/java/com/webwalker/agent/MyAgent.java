package com.webwalker.agent;

import java.lang.instrument.Instrumentation;

/**
 * Created by xujian on 2016/8/3.
 */
public class MyAgent {
    //JVM启动完成后
    public static void agentmain(String agentArgs, Instrumentation instrumentation) {
        premain(agentArgs, instrumentation);
    }

    /* 启动JVM时（Required）
    *  该方法在main方法之前运行，与main方法运行在同一个JVM中
    *  并被同一个System ClassLoader装载
    *  被统一的安全策略(security policy)和上下文(context)管理
    */
    public static void premain(String agentArgs, Instrumentation inst) {
        Class[] classes = inst.getAllLoadedClasses(); //所有JVM加载的类
        for (Class cls : classes) {
            System.out.println(cls.getName());
        }
        inst.addTransformer(new PeopleClassFileTransformer());
    }

    /*
    * 如果不存在 premain(String agentOps, Instrumentation inst)
    * 则会执行 premain(String agentOps)
    */
    public static void premain(String agentOps) {
        System.out.println("=========premain方法执行2========");
        System.out.println(agentOps);
    }
}