package com.voronin.qa.models.web.interfaces;

public interface WebPage {

    void open();

    void close();

    void forward();

    void back();

    void refresh();
}
