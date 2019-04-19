package com.voronin.qa.constructors.abstract_builder;

import java.util.Objects;

public class Calzone extends AbstractPizzaBuilder {

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

    @Override public boolean equals( Object o ) {
        if ( this == o ) return true;
        if ( !( o instanceof Calzone ) ) return false;
        Calzone calzone = ( Calzone ) o;
        return this.sauceInside == calzone.sauceInside;
    }

    @Override public int hashCode() {
        return Objects.hash( this.sauceInside );
    }

    @Override public String toString() {
        final StringBuilder sb;
        sb = new StringBuilder( "Calzone{" );
        sb.append( "sauceInside=" ).append( sauceInside );
        sb.append( ", toppings=" ).append( toppings );
        sb.append( '}' );
        return sb.toString();
    }
}
