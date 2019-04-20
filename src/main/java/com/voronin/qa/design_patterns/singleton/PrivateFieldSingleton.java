package com.voronin.qa.design_patterns.singleton;

public class PrivateFieldSingleton {

    private static final PrivateFieldSingleton SINGLETON = new PrivateFieldSingleton();

    private PrivateFieldSingleton() { }

    public static PrivateFieldSingleton getInstance() {
        return SINGLETON;
    }
}

class PrivateFieldSingletonDemo {

    public static void main( String[] args ) {
        PrivateFieldSingleton singleton = PrivateFieldSingleton.getInstance();
        System.out.println( singleton );
    }
}