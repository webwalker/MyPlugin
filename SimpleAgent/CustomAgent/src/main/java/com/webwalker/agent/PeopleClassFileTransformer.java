package com.webwalker.agent;

import java.io.IOException;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.NotFoundException;

/**
 * Created by xujian on 2016/8/3.
 */
public class PeopleClassFileTransformer implements ClassFileTransformer {

    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
        System.out.println("load class:"+className);
        if("com.webwalker.java.agent.People".equals(className)){
            try {
                //通过javassist修改sayHello方法字节码
                CtClass ctClass= ClassPool.getDefault().get(className.replace('/','.'));
                CtMethod sayHelloMethod=ctClass.getDeclaredMethod("sayHello");
                sayHelloMethod.insertBefore("System.out.println(\"before sayHello----\");");
                sayHelloMethod.insertAfter("System.out.println(\"after sayHello----\");");
                return ctClass.toBytecode();
            } catch (NotFoundException e) {
                e.printStackTrace();
            } catch (CannotCompileException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return classfileBuffer;
    }
}
