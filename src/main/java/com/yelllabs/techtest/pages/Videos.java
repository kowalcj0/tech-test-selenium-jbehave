package com.yelllabs.techtest.pages;

import org.jbehave.web.selenium.FluentWebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.By;
import static org.seleniumhq.selenium.fluent.Period.secs;
import org.seleniumhq.selenium.fluent.FluentWebElements;

public class Videos extends FluentWebDriverPage {

    private By listOfVideos = By.cssSelector("ul.reel li");


    public Videos(WebDriverProvider webDriverProvider) {
        super(webDriverProvider);
    }

    /*
      Go directly to this page
    */
    public void go(){
        get("http://www.yell.com/videos");
    }


    public int getNumberOfFeaturedVideos(){
        return findVideos().size();
    }


    private FluentWebElements findVideos(){
        return within(secs(2)).lis(listOfVideos);
    }
}