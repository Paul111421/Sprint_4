import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import testvar.HomePage;

public class BaseTest {

    public WebDriver driver;
    private final String browserName;
    public BaseTest(String browserName){
        this.browserName = browserName;
    }
    @Before
    public void setUp(){

        if("firefox".equals(browserName)){
            System.setProperty("webdriver.gecko.driver","/home/vdwv/WebDriver/bin/geckodriver");
            driver = new FirefoxDriver();
        } else if("chrome".equals(browserName)){
            System.setProperty("webdriver.chrome.driver", "/home/vdwv/WebDriver/bin/chromedriver-linux64/chromedriver");
            ChromeOptions options = new ChromeOptions();
            options.setBinary("/usr/bin/google-chrome-stable");
            driver = new ChromeDriver(options);
        }
        driver.manage().window().maximize();
        driver.get(HomePage.getSamokatUrl());
    }

    @After
    public void teardown(){
        driver.quit();
    }
}

//Какая глупость! Я создавал в основных тестах поле driver, а здесь уже driver инициализирован!
//Тобишь программа видела, что драйвер в BaseTest запущен, но по инерции обращалась к своему WebDriver внутри класса-наследника
//Так вот откуда NullPointerExtension ошибка была... класс, я понял! :)