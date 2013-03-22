package com.yelllabs.techtest.pages;

import org.jbehave.web.selenium.FluentWebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.seleniumhq.selenium.fluent.FluentWebElement;

import static org.openqa.selenium.By.*;

/**
 * Page object defining the home page
 */
public class Home extends FluentWebDriverPage {

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
        input(id("search_whatInput")).clearField().sendKeys(what);
        input(id("location")).clearField().sendKeys(where);
        button(cssSelector("button.search-submit")).click();
    }

    public void goToReviewsSection() {
        link(linkText("Reviews")).click();
    }

    public void goToVideosSection() {
        link(linkText("Videos")).click();
    }
}
