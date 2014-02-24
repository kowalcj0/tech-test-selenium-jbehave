package tech.test.pages;

import org.jbehave.web.selenium.FluentWebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.WebElement;
import org.seleniumhq.selenium.fluent.FluentMatcher;
import org.seleniumhq.selenium.fluent.FluentWebElements;
import static org.openqa.selenium.By.*;
import static org.seleniumhq.selenium.fluent.Period.secs;

public class SearchResults extends FluentWebDriverPage {

    public SearchResults(WebDriverProvider webDriverProvider) {
        super(webDriverProvider);
    }

    public int resultsFound() {
        return getResultElements().size();
    }


    private FluentWebElements getResultElements() {
        return within(secs(5)).divs(className("parentListing"));
    }

    private FluentMatcher lowerCaseTitleContaining(final String thing) {
        return new FluentMatcher() {
            public boolean matches(WebElement webElement) {
                return webElement.getAttribute("title").toLowerCase().contains(thing);
            }
        };
    }
}