package com.voronin.qa.design_patterns.factory_method.lambda_style;

import java.util.Date;
import java.util.function.Supplier;

interface Watch {

    void showTime();
}

class WatchMaker {

    Watch createWatch( Supplier < Watch > watch ) {
        return watch.get();
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

class WatchLambdaDemo {

    public static void main( String[] args ) {

        WatchMaker watchMaker = new WatchMaker();


        Watch digitalWatch = watchMaker
                .createWatch( DigitalWatch :: new );

        digitalWatch.showTime();

        Watch romeWatch = watchMaker
                .createWatch( RomeWatch :: new );

        romeWatch.showTime();
    }
}


