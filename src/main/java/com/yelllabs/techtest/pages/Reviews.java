package com.yelllabs.techtest.pages;

import org.jbehave.web.selenium.FluentWebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.WebElement;
import org.seleniumhq.selenium.fluent.FluentMatcher;
import org.seleniumhq.selenium.fluent.FluentWebElements;

import static org.openqa.selenium.By.cssSelector;
import static org.seleniumhq.selenium.fluent.Period.secs;

public class Reviews extends FluentWebDriverPage {

    public Reviews(WebDriverProvider webDriverProvider) {
        super(webDriverProvider);
    }

    /**
     * Go directly to this page
    */
    public void go(){
        get("http://www.yell.com/reviews");
    }


}