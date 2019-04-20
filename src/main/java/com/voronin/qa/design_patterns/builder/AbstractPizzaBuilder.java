package com.voronin.qa.design_patterns.builder;

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

class NyPizza extends AbstractPizzaBuilder {

    public enum Size {
        SMALL,
        MEDIUM,
        LARGE
    }

    private final Size size;

    public static class Builder extends AbstractPizzaBuilder.Builder < Builder > {

        private final Size size;

        public Builder( Size size ) {
            this.size = Objects.requireNonNull( size );
        }

        @Override
        public NyPizza build() {
            return new NyPizza( this );
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    public NyPizza( Builder builder ) {
        super( builder );
        this.size = builder.size;
    }

    @Override
    public boolean equals( Object o ) {
        if ( this == o ) return true;
        if ( !( o instanceof NyPizza ) ) return false;
        NyPizza pizza = ( NyPizza ) o;
        return this.size == pizza.size;
    }

    @Override
    public int hashCode() {
        return Objects.hash( this.size );
    }

    @Override
    public String toString() {
        final StringBuilder sb;
        sb = new StringBuilder( "NyPizza{" );
        sb.append( "size=" ).append( size );
        sb.append( ", toppings=" ).append( toppings );
        sb.append( '}' );
        return sb.toString();
    }
}

class Calzone extends AbstractPizzaBuilder {

    private final boolean sauceInside;

    public static class Builder extends AbstractPizzaBuilder.Builder < Builder > {

        private boolean sauceInside = false;  //По умолчанию

        public Builder sauceInside() {
            sauceInside = true;
            return this;
        }

        @Override
        public Calzone build() {
            return new Calzone( this );
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    private Calzone( Builder builder ) {
        super( builder );
        this.sauceInside = builder.sauceInside;
    }

    @Override
    public boolean equals( Object o ) {
        if ( this == o ) return true;
        if ( !( o instanceof Calzone ) ) return false;
        Calzone calzone = ( Calzone ) o;
        return this.sauceInside == calzone.sauceInside;
    }

    @Override
    public int hashCode() {
        return Objects.hash( this.sauceInside );
    }

    @Override
    public String toString() {
        final StringBuilder sb;
        sb = new StringBuilder( "Calzone{" );
        sb.append( "sauceInside=" ).append( sauceInside );
        sb.append( ", toppings=" ).append( toppings );
        sb.append( '}' );
        return sb.toString();
    }
}

class PizzaDemo {

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