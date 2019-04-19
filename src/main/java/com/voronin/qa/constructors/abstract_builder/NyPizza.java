package com.voronin.qa.constructors.abstract_builder;

import java.util.Objects;

public class NyPizza extends AbstractPizzaBuilder {

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

    @Override public boolean equals( Object o ) {
        if ( this == o ) return true;
        if ( !( o instanceof NyPizza ) ) return false;
        NyPizza pizza = ( NyPizza ) o;
        return this.size == pizza.size;
    }

    @Override public int hashCode() {
        return Objects.hash( this.size );
    }

    @Override public String toString() {
        final StringBuilder sb;
        sb = new StringBuilder( "NyPizza{" );
        sb.append( "size=" ).append( size );
        sb.append( ", toppings=" ).append( toppings );
        sb.append( '}' );
        return sb.toString();
    }
}
