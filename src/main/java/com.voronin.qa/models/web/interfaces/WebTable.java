package com.voronin.qa.models.web.interfaces;

import org.openqa.selenium.WebElement;

/**
 *
 */
public interface WebTable {

    /**
     * @param row
     * @param col
     *
     * @return
     */
    WebElement getHeaderCell( int row , int col );

    /**
     * @param row
     * @param col
     *
     * @return
     */
    WebElement getBodyCell( int row , int col );

    /**
     * @param row
     * @param col
     *
     * @return
     */
    WebElement getFooterCell( int row , int col );
}
