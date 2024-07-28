package armagan.steps;


import armagan.pages.MainPage;
import armagan.pages.ProductDetailPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import java.io.IOException;

public class ProductDetailPageSteps {

    ProductDetailPage productDetailPage = new ProductDetailPage();



    @And("adds product to the cart")
    public void addsProductToTheCart() {
        productDetailPage.verifyThatProductsAreSame();
        productDetailPage.addToCart();
    }

    @And("goes to the cart")
    public void goesToTheCart() {
        productDetailPage.goToTheCart();
    }
}
