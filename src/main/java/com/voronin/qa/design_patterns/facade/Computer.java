package com.voronin.qa.design_patterns.facade;

class Power {

    public void on() {
        System.out.println( "power on" );
    }

    public void off() {
        System.out.println( "power off" );
    }
}

class DVDRom {

    private boolean data;

    public boolean hasData() {
        return this.data;
    }

    public void load() {
        this.data = true;
        System.out.println( "disk loaded" );
    }

    public void unload() {
        this.data = false;
        System.out.println( "disk unloaded" );
    }
}

class HDD {

    public void copyFromDVDRom( DVDRom dvdRom ) {
        if ( dvdRom.hasData() ) {
            System.out.println( "copping" );
        } else {
            System.out.println( "enter dvd with data" );
        }
    }
}

/**
 * Класс Фасад
 */
public class Computer {

    private Power  power;
    private DVDRom dvdRom;
    private HDD    hdd;

    public Computer() {
        this.power  = new Power();
        this.dvdRom = new DVDRom();
        this.hdd    = new HDD();
    }

    public Computer( Power power , DVDRom dvdRom , HDD hdd ) {
        this.power  = power;
        this.dvdRom = dvdRom;
        this.hdd    = hdd;
    }

    public void copy() {
        this.power.on();
        this.dvdRom.load();
        this.hdd.copyFromDVDRom( this.dvdRom );
    }
}

class ComputerFacadeDemo {
    public static void main( String[] args ) {

        //        Power power = new Power();
        //        power.on();

        //        DVDRom dvdRom = new DVDRom();
        //        dvdRom.load();

        //        HDD hdd = new HDD();
        //        hdd.copyFromDVDRom( dvdRom );


        Computer computer = new Computer();
        computer.copy();
    }
}
