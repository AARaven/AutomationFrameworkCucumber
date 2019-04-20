package com.voronin.qa.design_patterns.singleton;

public class LazySingleton {

    private static LazySingleton singleton;

    private LazySingleton() { }

    public static LazySingleton getInstance() {
        return ( singleton == null )
               ? singleton = new LazySingleton()
               : singleton;
    }
}

class LazySingletonDemo {

    public static void main( String[] args ) {
        LazySingleton singleton = LazySingleton.getInstance();
        System.out.println( singleton );
    }
}