package com.voronin.qa.design_patterns.builder;

enum Engine {
    ENGINE
}

enum Transmission {
    TRANSMISSION
}

enum Brakes {
    BRAKES
}

enum Wheels {
    WHEELS
}

enum Doors {
    DOORS
}

enum Lights {
    LIGHTS
}

class Car {

    private final Engine       engine;
    private final Transmission transmission;
    private final Brakes       brakes;

    private final Wheels wheels;
    private final Doors  doors;
    private final Lights topLights;
    private final Lights backLights;

    public static class Builder {

        private final Engine       engine;
        private final Transmission transmission;
        private final Brakes       brakes;

        private Wheels wheels;
        private Doors  doors;
        private Lights topLights;
        private Lights backLights;

        public Builder( Engine engine , Transmission transmission , Brakes brakes ) {
            this.engine       = engine;
            this.transmission = transmission;
            this.brakes       = brakes;
        }

        public Builder addWheels( Wheels wheels ) {
            this.wheels = wheels;
            return this;
        }

        public Builder addDoors( Doors doors ) {
            this.doors = doors;
            return this;
        }

        public Builder addTopLights( Lights topLights ) {
            this.topLights = topLights;
            return this;
        }

        public Builder addBackLights( Lights backLights ) {
            this.backLights = backLights;
            return this;
        }

        public Car build() {
            return new Car( this );
        }
    }

    private Car( Builder builder ) {
        this.engine       = builder.engine;
        this.transmission = builder.transmission;
        this.brakes       = builder.brakes;
        this.wheels       = builder.wheels;
        this.doors        = builder.doors;
        this.topLights    = builder.topLights;
        this.backLights   = builder.backLights;
    }

    @Override
    public String toString() {
        final StringBuilder sb;
        sb = new StringBuilder( "Car{" );
        sb.append( "engine=" ).append( engine );
        sb.append( ", transmission=" ).append( transmission );
        sb.append( ", brakes=" ).append( brakes );
        sb.append( ", wheels=" ).append( wheels );
        sb.append( ", doors=" ).append( doors );
        sb.append( ", topLights=" ).append( topLights );
        sb.append( ", backLights=" ).append( backLights );
        sb.append( '}' );
        return sb.toString();
    }
}

class CarBuilderDemo {

    public static void main( String[] args ) {

        Car car = new Car.Builder( Engine.ENGINE , Transmission.TRANSMISSION , Brakes.BRAKES )
                .addDoors( Doors.DOORS )
                .addWheels( Wheels.WHEELS )
                .addTopLights( Lights.LIGHTS )
                .addBackLights( Lights.LIGHTS )
                .build();

        Car car1 = new Car.Builder( Engine.ENGINE , Transmission.TRANSMISSION , Brakes.BRAKES )
                .build();

        System.out.println( car );
        System.out.println( car1 );
    }
}