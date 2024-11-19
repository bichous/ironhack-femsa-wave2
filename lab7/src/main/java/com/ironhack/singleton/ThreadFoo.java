package com.ironhack.singleton;

class ThreadFoo implements Runnable {
    @Override
    public void run() {
        Singleton singleton = Singleton.getInstance("FOO");
        System.out.println(singleton.value);
    }
}
