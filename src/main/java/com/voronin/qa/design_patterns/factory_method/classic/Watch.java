package com.voronin.qa.design_patterns.factory_method.classic;

import java.util.Date;

interface Watch {

    void showTime();
}

interface WatchMaker {

    Watch createWatch();
}

class DigitalWatchMaker {

    Watch createWatch() {
        return new DigitalWatch();
    }
}

class RomeWatchMaker {

    Watch createWatch() {
        return new RomeWatch();
    }
}

class DigitalWatch implements Watch {

    @Override
    public void showTime() {
        System.out.println( new Date() );
    }
}

class RomeWatch implements Watch {


    @Override
    public void showTime() {
        System.out.println( "VII-XX" );
    }
}

class WatchDemo {

    public static void main( String[] args ) {
        DigitalWatchMaker digitalWatchMaker = new DigitalWatchMaker();
        Watch             digitWatch        = digitalWatchMaker.createWatch();

        RomeWatchMaker romeWatchMaker = new RomeWatchMaker();
        Watch          romeWatch      = romeWatchMaker.createWatch();

        digitWatch.showTime();
        romeWatch.showTime();
    }
}