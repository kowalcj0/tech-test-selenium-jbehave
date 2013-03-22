package com.yelllabs.techtest.pages;

import org.jbehave.web.selenium.FluentWebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;

public class Videos extends FluentWebDriverPage {

    public Videos(WebDriverProvider webDriverProvider) {
        super(webDriverProvider);
    }

    /**
     * Go directly to this page
    */
    public void go(){
        get("http://www.yell.com/videos");
    }


}