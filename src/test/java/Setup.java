import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class Setup {

    private static final Supplier<WebDriver> chromeSupplier = () -> {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\jagla\\Desktop\\web_drivers\\chromedriver.exe");
        return new ChromeDriver();
    };
    private static final Supplier<WebDriver> chromeHeadlessSupplier = () -> {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\jagla\\Desktop\\web_drivers\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200","--ignore-certificate-errors", "--silent");
        return new ChromeDriver(options);
    };

    private static final Supplier<WebDriver> firefoxSupplier = () -> {
        System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\Mozilla Firefox\\firefox.exe");
        return new FirefoxDriver();
    };

    private static final Map<String, Supplier<WebDriver>> MAP = new HashMap<>();
    static {
        MAP.put("chrome", chromeSupplier);
        MAP.put("firefox",firefoxSupplier);
        MAP.put("chromeheadless", chromeHeadlessSupplier);
    }

    public static WebDriver getDriver(String browser){
        return MAP.get(browser).get();
    }

}
