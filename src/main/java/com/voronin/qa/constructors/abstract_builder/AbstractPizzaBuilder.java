package com.voronin.qa.constructors.abstract_builder;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

/**
 * Шаблон Builder(Строитель) для иерархий классов
 */
public abstract class AbstractPizzaBuilder {

    public enum Topping {
        HAM,
        MUSHROOM,
        ONION,
        PEPPER,
        SAUSAGE
    }

    protected final Set < Topping > toppings;

    abstract static class Builder < T extends Builder < T > > {

        //Пустой EnumSet типизированный под хранение экземпляров (enum) Topping
        private EnumSet < Topping > toppings = EnumSet.noneOf( Topping.class );

        public T addTopping( Topping topping ) {
            toppings.add( Objects.requireNonNull( topping ) );
            return self();
        }

        public abstract AbstractPizzaBuilder build();

        // Подклассы должны перекрывать этот метод, возвращая "себя"
        protected abstract T self();
    }

    public AbstractPizzaBuilder( Builder < ? > builder ) {
        this.toppings = builder.toppings.clone();
    }
}
