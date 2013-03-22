package com.yelllabs.techtest.pages;

import org.jbehave.web.selenium.WebDriverProvider;


/**
 * PageFactory that is used to instantiate desired page object
 */
public class PageFactory {

    private final WebDriverProvider webDriverProvider;

    public PageFactory(WebDriverProvider webDriverProvider) {
        this.webDriverProvider = webDriverProvider;
    }

    public Home newHome() {
        return new Home(webDriverProvider);
    }

    public SearchResults newSearchResults() {
        return new SearchResults(webDriverProvider);
    }

    public Maps newMaps() {
        return new Maps(webDriverProvider);
    }

    public Reviews newReviews() {
        return new Reviews(webDriverProvider);
    }

    public Videos newVideos() {
        return new Videos(webDriverProvider);
    }

}
