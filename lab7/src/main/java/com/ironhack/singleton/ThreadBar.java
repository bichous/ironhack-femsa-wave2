package com.ironhack.singleton;

class ThreadBar implements Runnable {
    @Override
    public void run() {
        Singleton singleton = Singleton.getInstance("BAR");
        System.out.println(singleton.value);
    }
}
