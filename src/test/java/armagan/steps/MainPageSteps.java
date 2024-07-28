package armagan.steps;


import armagan.pages.MainPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import java.io.IOException;

public class MainPageSteps {

    MainPage mainPage = new MainPage();


    @Given("user searches for {string}")
    public void userSearchesFor(String productToBeSearched) {
        mainPage.searchFor(productToBeSearched);
    }
}
