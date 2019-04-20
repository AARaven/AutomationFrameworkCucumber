package com.voronin.qa.design_patterns.builder;

import java.util.Objects;

/**
 * Шаблон JavaBeans - обеспечивает изменяемость
 */
public class NutritionFactsJavaBean {

    // Параметры инициализируются значениями
    // по умолчанию (если таковые имеются)

    private int servingSize  = -1;   // Необходим; значения по умолчанию нет:
    private int servings     = -1;   // Необходим; значения по умолчанию нет:
    private int calories     = 0;
    private int fat          = 0;
    private int sodium       = 0;
    private int carbohydrate = 0;

    public NutritionFactsJavaBean() { }

    public int getServingSize() {
        return this.servingSize;
    }

    public void setServingSize( int servingSize ) {
        this.servingSize = servingSize;
    }

    public int getServings() {
        return this.servings;
    }

    public void setServings( int servings ) {
        this.servings = servings;
    }

    public int getCalories() {
        return this.calories;
    }

    public void setCalories( int calories ) {
        this.calories = calories;
    }

    public int getFat() {
        return this.fat;
    }

    public void setFat( int fat ) {
        this.fat = fat;
    }

    public int getSodium() {
        return this.sodium;
    }

    public void setSodium( int sodium ) {
        this.sodium = sodium;
    }

    public int getCarbohydrate() {
        return this.carbohydrate;
    }

    public void setCarbohydrate( int carbohydrate ) {
        this.carbohydrate = carbohydrate;
    }

    @Override
    public boolean equals( Object o ) {
        if ( this == o ) return true;
        if ( !( o instanceof NutritionFactsJavaBean ) ) return false;
        NutritionFactsJavaBean that = ( NutritionFactsJavaBean ) o;
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
        sb = new StringBuilder( "NutritionFactsJavaBean{" );
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

class NutritionFactsJavaBeanDemo {

    public static void main( String[] args ) {

        NutritionFactsJavaBean cocaCola = new NutritionFactsJavaBean();

        cocaCola.setCarbohydrate( 5 );
        cocaCola.setServingSize( 5 );
        cocaCola.setServings( 5 );
        cocaCola.setCalories( 5 );
        cocaCola.setSodium( 5 );
        cocaCola.setFat( 5 );

        System.out.println( cocaCola );
    }
}