package com.yelllabs.techtest.steps;

import org.hamcrest.Matchers;
import org.jbehave.core.annotations.*;
import com.yelllabs.techtest.pages.Home;
import com.yelllabs.techtest.pages.PageFactory;
import com.yelllabs.techtest.pages.SearchResults;

import static org.hamcrest.MatcherAssert.assertThat;

public class Steps {

    private Home home;
    private SearchResults searchResults;

    public Steps(PageFactory pageFactory){
        home = pageFactory.newHome();
        searchResults = pageFactory.newSearchResults();
    }

    @Given("I am on Yell.com")
    public void homepageOnYellDotCom() {
        home.go();
    }

    @When("I search for a <profession> in <location>")
    public void specifySearchLocation(@Named("profession") String profession, @Named("location") String location) {
        home.searchForWhatWhere(profession, location);
    }


    @Then("there are search results")
    @Alias("results will be displayed in the list view")
    public void thereAreSearchResults() {
        assertThat(searchResults.resultsFound(), Matchers.greaterThan(0));
    }


    @When("I want to browse the reviews")
    public void goToReviews() {
        home.goToReviewsSection();
    }

    @When("I want to browse the videos")
    public void goToVideos() {
        home.goToVideosSection();
    }

    @When("I want to browse through featured videos")
    @Composite(steps = {"Given I am on Yell.com",
                        "When I want to browse the videos"})
    public void browseToTheFeaturedVideosSection() {
    }
}
