package org.example.design.singleton;

public class EagerSingleton {



    private static final EagerSingleton instance = new EagerSingleton();

    private EagerSingleton() {
        System.out.println("method is calles!");

        // Private constructor to prevent external instantiation

    }

    public static EagerSingleton getInstance() {



        return instance;

    }

}
