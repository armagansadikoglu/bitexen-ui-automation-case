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

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class ProductDetailPage {

    SelenideElement productTitle = $("#productTitle");
    SelenideElement priceElement = $("#corePrice_feature_div");
    SelenideElement addToCartButton = $("#add-to-cart-button");
    SelenideElement goToTheCartButton = $x("//a[contains(text(),'Sepete Git')]");
    Logger logger;

    public ProductDetailPage() {
        logger = LogManager.getLogger(ProductDetailPage.class);
    }


    public void verifyThatProductsAreSame() {
        productTitle
                .shouldBe(visible, Duration.ofSeconds(60))
                .shouldBe(text(Util.getProductName()), Duration.ofSeconds(60));
        logger.log(Level.INFO, "Ürün detay sayfası ürünün adı : " + productTitle.getText());
        String priceString = Util.getPriceString(priceElement);
        logger.log(Level.INFO, "Ürün detay sayfası ürünün fiyatı : " + priceString);
        Assert.assertEquals(priceString, Util.getProductPrice());
        Assert.assertEquals(productTitle.getText(), Util.getProductName());
    }

    public void addToCart() {
        addToCartButton
                .shouldBe(visible, Duration.ofSeconds(60))
                .shouldBe(interactable, Duration.ofSeconds(60))
                .click();
        logger.log(Level.INFO, "Ürün sepete eklendi");
    }

    public void goToTheCart() {
        goToTheCartButton
                .shouldBe(visible, Duration.ofSeconds(60))
                .shouldBe(interactable, Duration.ofSeconds(60))
                .click();
        logger.log(Level.INFO, "Sepete Git butonuna tıklandı");
    }
}
