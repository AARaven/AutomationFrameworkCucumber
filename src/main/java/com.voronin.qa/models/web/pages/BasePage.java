package com.voronin.qa.models.web.pages;

import com.voronin.qa.models.web.abstracts.AbstractWebPage;
import org.openqa.selenium.WebDriver;

public class BasePage extends AbstractWebPage {

    public BasePage( WebDriver driver ) {
        super( driver );
    }
}
