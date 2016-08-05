package com.webwalker.agent;

import java.lang.instrument.Instrumentation;

/**
 * Created by xujian on 2016/8/3.
 */
public class MyAgent {
    //JVM������ɺ�
    public static void agentmain(String agentArgs, Instrumentation instrumentation) {
        premain(agentArgs, instrumentation);
    }

    /* ����JVMʱ��Required��
    *  �÷�����main����֮ǰ���У���main����������ͬһ��JVM��
    *  ����ͬһ��System ClassLoaderװ��
    *  ��ͳһ�İ�ȫ����(security policy)��������(context)����
    */
    public static void premain(String agentArgs, Instrumentation inst) {
        Class[] classes = inst.getAllLoadedClasses(); //����JVM���ص���
        for (Class cls : classes) {
            System.out.println(cls.getName());
        }
        inst.addTransformer(new PeopleClassFileTransformer());
    }

    /*
    * ��������� premain(String agentOps, Instrumentation inst)
    * ���ִ�� premain(String agentOps)
    */
    public static void premain(String agentOps) {
        System.out.println("=========premain����ִ��2========");
        System.out.println(agentOps);
    }
}
