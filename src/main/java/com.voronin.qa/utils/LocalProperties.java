package com.voronin.qa.utils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Properties;

/**
 * This class provides util methods for properties files
 */
public class LocalProperties {

    private static final Properties properties;

    static {
        properties = new Properties();
    }

    /**
     * @param file {@code File} file
     */
    public static void readProperties( File file ) {
        try {
            if ( file.isDirectory() ) {
                readProperties( Arrays.asList( Objects.requireNonNull( file.listFiles() ) ) );
            }
            if ( file.toString().endsWith( ".properties" ) ) {
                properties.load( new FileReader( file ) );
            }
        } catch ( IOException e ) {
            e.printStackTrace();
        }
    }

    /**
     * @param files {@code List<File>} list of files with .properties suffix
     *
     * @throws IOException
     */
    private static void readProperties( List < File > files ) throws IOException {
        for ( File file : files ) {
            if ( file.toString().endsWith( ".properties" ) ) {
                properties.load( new FileReader( file ) );
            }
        }
    }

    /**
     * @param key {@code String} parameter with key
     *
     * @return {@code String} value associated with key parameter
     */
    public static String getProperty( String key ) {
        return properties.getProperty( key );
    }
}