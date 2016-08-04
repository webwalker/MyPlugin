package com.webwalker.test;

import com.webwalker.agent.People;

/**
 * Created by xujian on 2016/7/6.
 */
public class MainClassTest {
    public static void main(String[] args) {
        start();
    }

    public static void start() {
        People people = new People();
        people.sayHello();
    }
}