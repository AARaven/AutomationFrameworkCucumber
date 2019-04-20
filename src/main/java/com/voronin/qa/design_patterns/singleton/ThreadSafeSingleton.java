package com.voronin.qa.design_patterns.singleton;

public class ThreadSafeSingleton {

    private static ThreadSafeSingleton singleton;

    private ThreadSafeSingleton() {}

    public static synchronized ThreadSafeSingleton getInstance() {
        return ( singleton == null )
               ? singleton = new ThreadSafeSingleton()
               : singleton;
    }
}

class ThreadSafeSingletonDemo {

    public static void main( String[] args ) {
        ThreadSafeSingleton singleton = ThreadSafeSingleton.getInstance();
        System.out.println( singleton );
    }
}