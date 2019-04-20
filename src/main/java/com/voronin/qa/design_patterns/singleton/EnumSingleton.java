package com.voronin.qa.design_patterns.singleton;

public enum EnumSingleton {
    INSTANCE
}

class EnumSingletonDemo {

    public static void main( String[] args ) {
        EnumSingleton singleton = EnumSingleton.INSTANCE;
        System.out.println( singleton );
    }
}