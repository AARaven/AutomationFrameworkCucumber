package com.voronin.qa.design_patterns.singleton;

public class ThreadLocalSingleton {

    private static final ThreadLocal < ThreadLocalSingleton > THREAD_LOCAL = new ThreadLocal <>();

    private ThreadLocalSingleton() {}

    public static ThreadLocalSingleton getInstance() {

        ThreadLocalSingleton singleton = THREAD_LOCAL.get();

        if ( singleton == null ) {
            singleton = new ThreadLocalSingleton();
            THREAD_LOCAL.set( singleton );
        }

        return singleton;
    }
}

class ThreadLocalSingletonDemo {

    public static void main( String[] args ) {
        ThreadLocalSingleton singleton = ThreadLocalSingleton.getInstance();
        System.out.println( singleton );
    }
}