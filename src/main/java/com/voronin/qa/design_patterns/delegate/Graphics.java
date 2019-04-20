package com.voronin.qa.design_patterns.delegate;

import java.util.Objects;

public interface Graphics {
    void draw();
}

class Painter {

    private final Graphics graphics;

    public Painter( Graphics graphics ) {
        this.graphics = graphics;
    }

    public void paint() {
        this.graphics.draw();
    }

    @Override
    public boolean equals( Object o ) {
        if ( this == o ) return true;
        if ( !( o instanceof Painter ) ) return false;
        Painter painter = ( Painter ) o;
        return this.graphics.equals( painter.graphics );
    }

    @Override
    public int hashCode() {
        return Objects.hash( this.graphics );
    }

    @Override
    public String toString() {
        final StringBuilder sb;
        sb = new StringBuilder( "Painter{" );
        sb.append( "graphics=" ).append( this.graphics );
        sb.append( '}' );
        return sb.toString();
    }
}

abstract class Shape implements Graphics {

    protected double length;
    protected double width;
    protected double height;

    protected double getLength() {
        return this.length;
    }

    protected void setLength( double length ) {
        this.length = length;
    }

    protected double getWidth() {
        return this.width;
    }

    protected void setWidth( double width ) {
        this.width = width;
    }

    protected double getHeight() {
        return this.height;
    }

    protected void setHeight( double height ) {
        this.height = height;
    }

    protected Shape() { }

    protected Shape( double length , double width ) {
        this( length , width , 0 );
    }

    protected Shape( double length , double width , double height ) {
        this.length = length;
        this.width  = width;
        this.height = height;
    }

    @Override
    public boolean equals( Object o ) {
        if ( this == o ) return true;
        if ( !( o instanceof Shape ) ) return false;
        Shape shape = ( Shape ) o;
        return Double.compare( shape.length , this.length ) == 0 &&
               Double.compare( shape.width , this.width ) == 0 &&
               Double.compare( shape.height , this.height ) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash( this.length ,
                             this.width ,
                             this.height );
    }

    @Override
    public String toString() {
        final StringBuilder sb;
        sb = new StringBuilder( "Shape{" );
        sb.append( "length=" ).append( this.length );
        sb.append( ", width=" ).append( this.width );
        sb.append( ", height=" ).append( this.height );
        sb.append( '}' );
        return sb.toString();
    }
}

class Circle extends Shape {

    private final double radius;

    public Circle( double radius ) {
        super();
        this.radius = radius;
    }

    @Override
    public boolean equals( Object o ) {
        if ( this == o ) return true;
        if ( !( o instanceof Circle ) ) return false;
        if ( !super.equals( o ) ) return false;
        Circle circle = ( Circle ) o;
        return Double.compare( circle.radius , this.radius ) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash( super.hashCode() , this.radius );
    }

    @Override
    public String toString() {
        final StringBuilder sb;
        sb = new StringBuilder( "Circle{" );
        sb.append( "radius=" ).append( this.radius );
        sb.append( '}' );
        return sb.toString();
    }

    @Override
    public void draw() {
        System.out.println( this );
    }
}

class Rectangle extends Shape {

    public Rectangle( double length , double width ) {
        super( length , width );
    }

    @Override
    protected double getLength() {
        return super.getLength();
    }

    @Override
    protected void setLength( double length ) {
        super.setLength( length );
    }

    @Override
    protected double getWidth() {
        return super.getWidth();
    }

    @Override
    protected void setWidth( double width ) {
        super.setWidth( width );
    }

    @Override
    public boolean equals( Object o ) {
        return super.equals( o );
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        final StringBuilder sb;
        sb = new StringBuilder( "Rectangle{" );
        sb.append( "length=" ).append( this.length );
        sb.append( ", width=" ).append( this.width );
        sb.append( '}' );
        return sb.toString();
    }

    @Override
    public void draw() {
        System.out.println( this );
    }
}

class Triangle extends Shape {

    public Triangle( double length , double width , double height ) {
        super( length , width , height );
    }

    @Override
    protected double getLength() {
        return super.getLength();
    }

    @Override
    protected void setLength( double length ) {
        super.setLength( length );
    }

    @Override
    protected double getWidth() {
        return super.getWidth();
    }

    @Override
    protected void setWidth( double width ) {
        super.setWidth( width );
    }

    @Override
    protected double getHeight() {
        return super.getHeight();
    }

    @Override
    protected void setHeight( double height ) {
        super.setHeight( height );
    }

    @Override
    public boolean equals( Object o ) {
        return super.equals( o );
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        final StringBuilder sb;
        sb = new StringBuilder( "Triangle{" );
        sb.append( "length=" ).append( this.length );
        sb.append( ", width=" ).append( this.width );
        sb.append( ", height=" ).append( this.height );
        sb.append( '}' );
        return sb.toString();
    }

    @Override
    public void draw() {
        System.out.println( this );
    }
}

class DelegateDemo {
    public static void main( String[] args ) {

        Circle    circle    = new Circle( 15.0 );
        Rectangle rectangle = new Rectangle( 5 , 10 );
        Triangle  triangle  = new Triangle( 5 , 5 , 5 );

        Painter circlePainter    = new Painter( circle );
        Painter rectanglePainter = new Painter( rectangle );
        Painter trianglePainter  = new Painter( triangle );

        circlePainter.paint();
        rectanglePainter.paint();
        trianglePainter.paint();
    }
}