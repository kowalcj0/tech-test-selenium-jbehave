package com.yelllabs.techtest.steps;

import org.jbehave.core.annotations.AfterScenario;
import org.jbehave.core.annotations.BeforeStories;
import org.jbehave.core.annotations.BeforeStory;
import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriverException;

import java.util.Set;

public class LifecycleSteps {

    private final WebDriverProvider webDriverProvider;

    public LifecycleSteps(WebDriverProvider webDriverProvider) {
        this.webDriverProvider = webDriverProvider;
    }


    @BeforeStories
    public void runBeforeAllStories() {
        try {
            // do something
            // ie. delete cookies
            System.out.println("You can run something here before executing all the stories!\n\n");
        } catch (WebDriverException e) {
            e.printStackTrace();
        }
    }

    @BeforeStory
    public void runBeforeEachStory() {
        try {
            // do something
            // ie. delete cookies
            System.out.println("You can run something here before executing every story!\n\n");
        } catch (WebDriverException e) {
            e.printStackTrace();
        }
    }

    @AfterScenario
    public void deleteAllCookies() {
        try {
            // do something
            // ie. delete cookies
            System.out.println("\nDeleting all the cookies!");
            Set<Cookie> cookies = webDriverProvider.get().manage().getCookies();
            for (Cookie c : cookies) {
                System.out.println("\tCookie: " + c.getName());
            }
            webDriverProvider.get().manage().deleteAllCookies();
            System.out.println("All cookies where deleted!");
        } catch (WebDriverException e) {
            e.printStackTrace();
        }
    }
}
