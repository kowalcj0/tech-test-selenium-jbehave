package com.yelllabs.techtest;

/**
 * Created with IntelliJ IDEA.
 * User: jk
 * Date: 22/03/13
 * Time: 15:50
 * To change this template use File | Settings | File Templates.
 */
import org.jbehave.core.InjectableEmbedder;
import org.jbehave.core.annotations.Configure;
import org.jbehave.core.annotations.UsingEmbedder;
import org.jbehave.core.annotations.spring.UsingSpring;
import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.embedder.StoryControls;
import org.jbehave.core.failures.FailingUponPendingStep;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.spring.SpringAnnotatedEmbedderRunner;
import org.jbehave.core.reporters.CrossReference;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.web.selenium.*;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static java.util.Arrays.asList;
import static org.jbehave.core.io.CodeLocations.codeLocationFromClass;
import static org.jbehave.core.reporters.Format.CONSOLE;
import static org.jbehave.web.selenium.WebDriverHtmlOutput.WEB_DRIVER_HTML;

@RunWith(SpringAnnotatedEmbedderRunner.class)
@Configure(using = SeleniumConfiguration.class, pendingStepStrategy = FailingUponPendingStep.class)
@UsingEmbedder(embedder = Embedder.class, generateViewAfterStories = true, ignoreFailureInStories = true, ignoreFailureInView = false, storyTimeoutInSecs = 50000, threads = 1, metaFilters = "-skip")
@UsingSpring(resources = {"techtest-steps.xml"})
public class RunSingleStory extends InjectableEmbedder {

        public RunSingleStory() {
        }

        @Test
        public void run() throws Throwable {
            CrossReference crossReference = new CrossReference().withJsonOnly().withOutputAfterEachStory(true)
                    .excludingStoriesWithNoExecutedScenarios(true);

            ContextView contextView = new LocalFrameContextView().sized(640, 120);

            SeleniumContext seleniumContext = new SeleniumContext();

            SeleniumStepMonitor stepMonitor = new SeleniumStepMonitor(contextView, seleniumContext,
                    crossReference.getStepMonitor());

            Format[] formats = new Format[] { new SeleniumContextOutput(seleniumContext), CONSOLE, WEB_DRIVER_HTML };

            StoryReporterBuilder reporterBuilder = new StoryReporterBuilder()
                    .withCodeLocation(codeLocationFromClass(Stories.class))
                    .withFailureTrace(true)
                    .withFailureTraceCompression(true)
                    .withDefaultFormats()
                    .withFormats(formats)
                    .withCrossReference(crossReference);

            Configuration configuration = injectedEmbedder().configuration();

            configuration.useFailureStrategy(new FailingUponPendingStep())
                    .useStoryControls(new StoryControls().doResetStateBeforeScenario(false)).useStepMonitor(stepMonitor)
                    .useStoryLoader(new LoadFromClasspath(Stories.class))
                    .useStoryReporterBuilder(reporterBuilder);
            if (configuration instanceof SeleniumConfiguration) {
                SeleniumConfiguration seleniumConfiguration = (SeleniumConfiguration) configuration;
                seleniumConfiguration.useSeleniumContext(seleniumContext);
            }
            injectedEmbedder().runStoriesAsPaths(storyPaths());
        }

        protected List<String> storyPaths()
        {
            return new StoryFinder().findPaths(codeLocationFromClass(this.getClass()).getFile(),
                    asList("**/" + System.getProperty("storyFilter", runTest()) + ".story"), null);
        }

        /**
         * The single test you want to run.
         *
         * E.g. if you want to run "create_article.story" you simply specify:
         *
         * return "create_article";
         *
         * @return
         */
        private String runTest()
        {
            return "etsy_cart";
        }

}
