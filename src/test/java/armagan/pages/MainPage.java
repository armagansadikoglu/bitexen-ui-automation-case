package armagan.pages;


import armagan.util.Util;
import com.codeborne.selenide.*;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.io.IOException;
import java.time.Duration;
import java.util.Random;


import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    SelenideElement searchBox = $("#twotabsearchtextbox");
    SelenideElement searchButton = $("#nav-search-submit-button");
    ElementsCollection articles = $$x("//div[@class='river river--homepage ']//article");
    ElementsCollection latestNewsAuthors = $$x("//span[@class='river-byline__authors']");

    ElementsCollection latestNewsImages = $$x("//div[@class='river river--homepage ']//article//img");

    ElementsCollection nonPremiumArticles = $$x("//div[@class='river river--homepage ']//article[not(contains(@class,'post-block--premium-content'))]//img");

    Logger logger;

    public MainPage() {
        logger = LogManager.getLogger(MainPage.class);
    }


    public void searchFor(String productToBeSearched) {
        searchBox
                .shouldBe(Condition.visible,Duration.ofSeconds(60))
                .shouldBe(Condition.interactable,Duration.ofSeconds(60))
                .setValue(productToBeSearched);
        logger.log(Level.INFO, "Typed product as " + productToBeSearched);
        searchButton
                .shouldBe(Condition.visible,Duration.ofSeconds(60))
                .shouldBe(Condition.interactable,Duration.ofSeconds(60))
                .click();
        logger.log(Level.INFO, "Clicked on search button");
    }
}
