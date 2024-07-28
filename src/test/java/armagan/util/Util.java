package armagan.util;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.Random;

public class Util {
    public static int getRandomNumber(){
        Random rand = new Random();

        // Generate random integers in range 0 to 9
         return rand.nextInt(10);
    }
    private static final ThreadLocal<String> productName = new ThreadLocal<>();
    private static final ThreadLocal<String> productPrice = new ThreadLocal<>();

    public static synchronized void setProductInformation(String prodName, String prodPrice) {
        productName.set(prodName);
        productPrice.set(prodPrice);
    }

    public static synchronized String getProductName() {
        return productName.get();
    }

    public static synchronized String getProductPrice() {
        return productPrice.get();
    }

    public static String getPriceString(SelenideElement priceElement) {
        String whole = priceElement.$(".a-price-whole").getText();
        String fraction = priceElement.$(".a-price-fraction").getText();
        String productPrice = whole + "," + fraction + "TL";
        return productPrice;
    }
}
