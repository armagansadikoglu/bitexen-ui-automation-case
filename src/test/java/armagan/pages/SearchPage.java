package armagan.pages;


import armagan.util.Util;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.$$x;

public class SearchPage {

  ElementsCollection searchResults = $$("[data-component-type='s-search-result']");
  String titleCss = "[data-cy='title-recipe']>h2";
  String priceBaseCss = "[data-cy='price-recipe'] span[aria-hidden='true']";
    Logger logger;

    public SearchPage() {
        logger = LogManager.getLogger(SearchPage.class);
    }


    public void selectAnyProduct() {
        logger.log(Level.INFO, "Arama sonuçlarının sıfırdan büyük olması bekleniyor");
        searchResults.shouldBe(CollectionCondition.sizeGreaterThan(0),Duration.ofSeconds(60));
        logger.log(Level.INFO, "Arama sonuçlarının sıfırdan büyük oldu : " + searchResults.size());

        int rand_int = Util.getRandomNumber();

        String productName = searchResults.get(rand_int).$(titleCss).getText();
        logger.log(Level.INFO, "Seçilen ürünün adı : " + productName);

        String productPrice =  Util.getPriceString(searchResults.get(rand_int).$(priceBaseCss));
        logger.log(Level.INFO, "Seçilen ürünün fiyatı : " + productPrice);

        searchResults.get(rand_int).$(priceBaseCss).scrollIntoView(true).click();
        logger.log(Level.INFO, "Clicked on product : ");

        Util.setProductInformation(productName,productPrice);

    }
}
