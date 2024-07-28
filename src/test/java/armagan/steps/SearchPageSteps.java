package armagan.steps;


import armagan.pages.MainPage;
import armagan.pages.SearchPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import java.io.IOException;

public class SearchPageSteps {

    SearchPage searchPage = new SearchPage();



    @When("user selects any product")
    public void userSelectsAnyProduct() {
        searchPage.selectAnyProduct();
    }
}
