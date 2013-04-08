package com.yelllabs.techtest.pages;

import org.jbehave.web.selenium.FluentWebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.By;

import static org.openqa.selenium.By.*;

/**
 * Page object defining the home page
 */
public class Home extends FluentWebDriverPage {

    /*
      Define page elements
    */
    private By linkReviews          = linkText("Reviews");
    private By inputSearchWhat      = id("search_whatInput");
    private By inputSearchWhere     = id("location");
    private By buttonSubmitSearch   = cssSelector("button.search-submit");
    private By linkVideos           = cssSelector("a[title='Videos']");

    /**
     * Default constructor
     * @param webDriverProvider
     */
    public Home(WebDriverProvider webDriverProvider) {
        super(webDriverProvider);
    }

    public void go() {
        get("http://www.yell.com");
    }

    public void go(String section) {
        go();
        link(xpath("@title = '" + section + "'")).click();
    }

    public void searchForWhatWhere(String what, String where) {
        input(inputSearchWhat).clearField().sendKeys(what);
        input(inputSearchWhere).clearField().sendKeys(where);
        button(buttonSubmitSearch).click();
    }

    public void goToReviewsSection() {
        link(linkReviews).click();
    }

    public void goToVideosSection() {
        link(linkVideos).click();
    }
}
