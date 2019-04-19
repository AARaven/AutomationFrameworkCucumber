package com.voronin.qa.constructors;

import java.util.Objects;

/**
 * Шаблон телескопического конструктора - не масштабируется !!!
 */
public class NutritionFactsTelescope {

    private final int servingSize;   // (мл в порции) Необходим
    private final int servings;      // (количество порций ) Необходим
    private final int calories;      // (калорий в порции) Необязателен
    private final int fat;           // (жиров в порции) Необязателен
    private final int sodium;        // (Na в порции) Необязателен
    private final int carbohydrate;  // (углеводы в порции)Необязателен

    public int getServingSize() {
        return this.servingSize;
    }

    public int getServings() {
        return this.servings;
    }

    public int getCalories() {
        return this.calories;
    }

    public int getFat() {
        return this.fat;
    }

    public int getSodium() {
        return this.sodium;
    }

    public int getCarbohydrate() {
        return this.carbohydrate;
    }

    public NutritionFactsTelescope( int servingSize , int servings ) {
        this( servingSize , servings , 1 );
    }

    public NutritionFactsTelescope( int servingSize , int servings , int calories ) {
        this( servingSize , servings , calories , 1 );
    }

    public NutritionFactsTelescope( int servingSize , int servings , int calories , int fat ) {
        this( servingSize , servings , calories , fat , 1 );
    }

    public NutritionFactsTelescope( int servingSize , int servings , int calories , int fat , int sodium ) {
        this( servingSize , servings , calories , fat , sodium , 1 );
    }

    public NutritionFactsTelescope( int servingSize , int servings , int calories , int fat , int sodium , int carbohydrate ) {
        this.servingSize  = servingSize;
        this.servings     = servings;
        this.calories     = calories;
        this.fat          = fat;
        this.sodium       = sodium;
        this.carbohydrate = carbohydrate;
    }

    @Override
    public boolean equals( Object o ) {
        if ( this == o ) return true;
        if ( !( o instanceof NutritionFactsTelescope ) ) return false;
        NutritionFactsTelescope that = ( NutritionFactsTelescope ) o;
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
        sb = new StringBuilder( "NutritionFactsTelescope{" );
        sb.append( "servingSize=" ).append( this.servingSize );
        sb.append( ", servings=" ).append( this.servings );
        sb.append( ", calories=" ).append( this.calories );
        sb.append( ", fat=" ).append( this.fat );
        sb.append( ", sodium=" ).append( this.sodium );
        sb.append( ", carbohydrate=" ).append( this.carbohydrate );
        sb.append( '}' );
        return sb.toString();
    }
}

class TelescopeConstructorDemo {
    public static void main( String[] args ) {
        NutritionFactsTelescope cocaCola = new NutritionFactsTelescope( 250 , 2 );
        System.out.println( cocaCola );
    }
}