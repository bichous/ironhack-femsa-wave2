package com.ironhack.singleton;

public class Main {

    public static void main(String[] args) {
        System.out.println("Si ves el mismo valor, es que se ha reutilizado el singleton" + "\n" +
                "Si ves valores diferentes, es que se han creado 2 singletons" + "\n\n" +
                "Resultado:" + "\n");
        Thread threadFoo = new Thread(new ThreadFoo());
        Thread threadBar = new Thread(new ThreadBar());
        threadFoo.start();
        threadBar.start();
    }
}
