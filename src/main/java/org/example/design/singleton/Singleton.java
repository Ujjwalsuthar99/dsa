package org.example.design.singleton;

public class Singleton {

    public final Object instance = null;

    private Singleton() {

    }

    public Object getInstance() {
        if (instance == null) {
            return new Singleton();
        }
        return instance;
    }


}