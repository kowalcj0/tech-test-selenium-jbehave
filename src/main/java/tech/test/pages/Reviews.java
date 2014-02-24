package tech.test.pages;

import org.jbehave.web.selenium.FluentWebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;

public class Reviews extends FluentWebDriverPage {

    public Reviews(WebDriverProvider webDriverProvider) {
        super(webDriverProvider);
    }

    /*
     Go directly to this page
    */
    public void go(){
        get("http://www.yell.com/reviews");
    }


}