package com.voronin.qa.constructors;

import java.util.Objects;

/**
 * Шаблон Builder(Строитель)
 */
public class NutritionFactsBuilder {

    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;

    public static class Builder {

        // Необходимые параметры
        private final int servingSize;
        private final int servings;

        // Необязательные параметры — инициализированы
        // значениями по умолчанию
        private int calories     = 0;
        private int fat          = 0;
        private int sodium       = 0;
        private int carbohydrate = 0;

        public Builder( int servingSize , int servings ) {
            if ( servingSize <= 0 || servings <= 0 ) {
                throw new IllegalArgumentException(
                        String.format( "Need to set positive value : {servingSize : %s}, {servings : %s}" ,
                                       servingSize ,
                                       servings ) );
            }
            this.servingSize = servingSize;
            this.servings    = servings;
        }

        public Builder calories( int calories ) {
            if ( calories <= 0 ) {
                throw new IllegalArgumentException(
                        String.format( "Need to set positive value : {calories : %s}" ,
                                       calories ) );
            }
            this.calories = calories;
            return this;
        }

        public Builder fat( int fat ) {
            if ( fat <= 0 ) {
                throw new IllegalArgumentException(
                        String.format( "Need to set positive value : {fat : %s}" ,
                                       fat ) );
            }
            this.fat = fat;
            return this;
        }

        public Builder sodium( int sodium ) {
            if ( sodium <= 0 ) {
                throw new IllegalArgumentException(
                        String.format( "Need to set positive value : {sodium : %s}" ,
                                       sodium ) );
            }
            this.sodium = sodium;
            return this;
        }

        public Builder carbohydrate( int carbohydrate ) {
            if ( carbohydrate <= 0 ) {
                throw new IllegalArgumentException(
                        String.format( "Need to set positive value : {carbohydrate : %s}" ,
                                       carbohydrate ) );
            }
            this.carbohydrate = carbohydrate;
            return this;
        }

        public NutritionFactsBuilder build() {
            return new NutritionFactsBuilder( this );
        }
    }

    private NutritionFactsBuilder( Builder builder ) {
        this.servingSize  = builder.servingSize;
        this.servings     = builder.servings;
        this.calories     = builder.calories;
        this.fat          = builder.fat;
        this.sodium       = builder.sodium;
        this.carbohydrate = builder.carbohydrate;
    }

    @Override
    public boolean equals( Object o ) {
        if ( this == o ) return true;
        if ( !( o instanceof NutritionFactsBuilder ) ) return false;
        NutritionFactsBuilder that = ( NutritionFactsBuilder ) o;
        return this.servingSize == that.servingSize &&
               this.servings == that.servings &&
               this.calories == that.calories &&
               this.fat == that.fat &&
               this.sodium == that.sodium &&
               this.carbohydrate == that.carbohydrate;
    }

    @Override
    public int hashCode() {
        return Objects.hash( this.servingSize ,
                             this.servings ,
                             this.calories ,
                             this.fat ,
                             this.sodium ,
                             this.carbohydrate );
    }

    @Override
    public String toString() {
        final StringBuilder sb;
        sb = new StringBuilder( "NutritionFactsBuilder{" );
        sb.append( "servingSize=" ).append( servingSize );
        sb.append( ", servings=" ).append( servings );
        sb.append( ", calories=" ).append( calories );
        sb.append( ", fat=" ).append( fat );
        sb.append( ", sodium=" ).append( sodium );
        sb.append( ", carbohydrate=" ).append( carbohydrate );
        sb.append( '}' );
        return sb.toString();
    }
}

class NutritionFactsBuilderDemo {
    public static void main( String[] args ) {
        NutritionFactsBuilder cocaCola =
                new NutritionFactsBuilder.Builder( 240 , 1 )
                        .calories( 50 ).fat( 40 ).sodium( 100 ).carbohydrate( 5 ).build();

        System.out.println( cocaCola );
    }
}
