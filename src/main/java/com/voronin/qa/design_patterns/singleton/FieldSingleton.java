package com.voronin.qa.design_patterns.singleton;

public class FieldSingleton {

    public static final FieldSingleton SINGLETON = new FieldSingleton();

    private FieldSingleton() { }
}

class FieldSingletonDemo {

    public static void main( String[] args ) {
        FieldSingleton singleton = FieldSingleton.SINGLETON;
        System.out.println( singleton );
    }
}