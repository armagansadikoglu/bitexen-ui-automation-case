package armagan.hooks;

import armagan.config.SutConfiguration;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import org.apache.commons.io.IOUtils;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;

import static com.codeborne.selenide.Condition.interactable;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class Hooks {


    @Before
    public void beforeEachScenario(Scenario scenario) {
        String browser = System.getProperty("selenide.browser");
        System.out.println("Browser " + browser);
        if (SutConfiguration.getProps().getProperty("isLocal").equalsIgnoreCase("false")){
            Configuration.remote = SutConfiguration.getProps().getProperty("gridUrl");
        }
        if (browser.equals("chrome")) {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--start-maximized");
            Configuration.browserCapabilities = chromeOptions;
        } else if (browser.equals("firefox")) {
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            Configuration.browserCapabilities = firefoxOptions;
        }
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10000;
        Configuration.remoteReadTimeout = 360000;
        Configuration.pageLoadTimeout = 120000;
        Selenide.open(SutConfiguration.getProps().getProperty("baseUrl"));
        System.out.println("********** Session ID : " + sessionId() + " --- Scenario : " + scenario.getName() + " ************");
        $x("//button[text()='Reddet']")
                .shouldBe(visible, Duration.ofSeconds(60))
                .shouldBe(interactable, Duration.ofSeconds(60))
                .click();
    }

    @After
    public void afterEachScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            takeSsAndAddToReport(scenario);
        }
        Selenide.closeWebDriver();
    }

    private void takeSsAndAddToReport(Scenario scenario) {
        String pngFileName = screenshot(scenario.getId());
        String attachmentName = scenario.getName();
        String os = System.getProperty("os.name");
        assert pngFileName != null;
        Path content;
        if (os.toLowerCase().contains("win")){
            content = Paths.get(pngFileName.replace("file:/", ""));
        }else {
           content = Paths.get(pngFileName.replace("file:", ""));
        }

        try (InputStream inputStream = Files.newInputStream(content)) {
            Allure.attachment(attachmentName, inputStream);
            byte[] bytes = IOUtils.toByteArray(inputStream);
            scenario.attach(bytes,"image/png","screenshot");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
