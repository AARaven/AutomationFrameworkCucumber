package com.voronin.qa.constructors.utils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Properties;

public class PropertiesReader {

    private final static Properties PROPERTIES;

    static {
        PROPERTIES = new Properties();
    }

    public static void loadPropFromFileOrDir( File file ) throws IOException {
        if ( file.isDirectory() ) {
            loadPropFromListFiles( Arrays.asList( Objects.requireNonNull( file.listFiles() ) ) );
        } else {
            PROPERTIES.load( new FileReader( file ) );
        }

    }

    public static void loadPropFromListFiles( List < File > fileList ) throws IOException {
        for ( File file : fileList ) {
            PROPERTIES.load( new FileReader( file ) );
        }
    }

    public static String getProperty( String key ) {
        return PROPERTIES.getProperty( key );
    }
}