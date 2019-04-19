package com.voronin.qa.constructors;

import com.voronin.qa.constructors.abstract_builder.AbstractPizzaBuilder;
import com.voronin.qa.constructors.abstract_builder.Calzone;
import com.voronin.qa.constructors.abstract_builder.NyPizza;

public class PizzaDemo {
    public static void main( String[] args ) {

        NyPizza pizza = new NyPizza.Builder( NyPizza.Size.SMALL )
                .addTopping( AbstractPizzaBuilder.Topping.MUSHROOM )
                .addTopping( AbstractPizzaBuilder.Topping.HAM )
                .addTopping( AbstractPizzaBuilder.Topping.ONION )
                .build();

        Calzone calzone = new Calzone.Builder()
                .addTopping( AbstractPizzaBuilder.Topping.PEPPER )
                .addTopping( AbstractPizzaBuilder.Topping.SAUSAGE )
                .sauceInside()
                .build();

        System.out.println( pizza );
        System.out.println( calzone );
    }
}