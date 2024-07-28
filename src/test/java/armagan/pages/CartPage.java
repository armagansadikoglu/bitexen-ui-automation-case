package armagan.pages;


import armagan.util.Util;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$x;

public class CartPage {

    SelenideElement productTitle = $("span[class*='sc-grid-item-product-title'] span[class*='a-truncate-cut']");
    Logger logger;
    SelenideElement priceElement = $(".a-size-medium.a-color-base.sc-price.sc-white-space-nowrap");
    public CartPage() {
        logger = LogManager.getLogger(CartPage.class);
    }



    public void checkTheCart() {

            productTitle
                    .shouldBe(visible, Duration.ofSeconds(60))
                    .shouldBe(text(Util.getProductName()), Duration.ofSeconds(60));
            logger.log(Level.INFO, "Sepet sayfası ürünün adı : " + productTitle.getText());
            String priceString = priceElement.getText().replace(" TL","TL");
            logger.log(Level.INFO, "Ürün detay sayfası ürünün fiyatı : " + priceString);
            Assert.assertEquals(priceString, Util.getProductPrice());
            Assert.assertEquals(productTitle.getText(), Util.getProductName());

    }
}
