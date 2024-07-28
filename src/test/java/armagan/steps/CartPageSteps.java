package armagan.steps;


import armagan.pages.CartPage;
import armagan.pages.MainPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

public class CartPageSteps {

    CartPage cartPage = new CartPage();


    @Then("user checks the cart")
    public void userChecksTheCart() {
        cartPage.checkTheCart();
    }
}
