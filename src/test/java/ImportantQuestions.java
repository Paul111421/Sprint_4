//Низ страницы
//8 вопросов на проверку
//Проверка - нажать на вопрос и сравнить ответы

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import testvar.HomePage;

@RunWith(Parameterized.class)
public class ImportantQuestions {

    private WebDriver driver;

    private final String browserName;

    public ImportantQuestions(String browserName){
        this.browserName = browserName;
    }

    @Parameterized.Parameters(name = "{0}")
    public static Object[][] getImportantQuestionsData(){
        return new Object[][]{
                {"firefox"},
                {"chrome"},
        };
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
        driver.get("https://qa-scooter.praktikum-services.ru/");

    }

    @Test
    public void questionTest(){

        String textActual;

        HomePage.clickCookieButton(driver);

        HomePage.clickQuestionOneHeading(driver);
        textActual = HomePage.getQuestionOnePanelText(driver);
        HomePage.assertQuestionOneTextExpectedActual(textActual);

        HomePage.clickQuestionTwoHeading(driver);
        textActual = HomePage.getQuestionTwoPanelText(driver);
        HomePage.assertQuestionTwoTextExpectedActual(textActual);

        HomePage.clickQuestionThreeHeading(driver);
        textActual = HomePage.getQuestionThreePanelText(driver);
        HomePage.assertQuestionThreeTextExpectedActual(textActual);

        HomePage.clickQuestionFourHeading(driver);
        textActual = HomePage.getQuestionFourPanelText(driver);
        HomePage.assertQuestionFourTextExpectedActual(textActual);

        HomePage.clickQuestionFiveHeading(driver);
        textActual = HomePage.getQuestionFivePanelText(driver);
        HomePage.assertQuestionFiveTextExpectedActual(textActual);

        HomePage.clickQuestionSixHeading(driver);
        textActual = HomePage.getQuestionSixPanelText(driver);
        HomePage.assertQuestionSixTextExpectedActual(textActual);

        HomePage.clickQuestionSevenHeading(driver);
        textActual = HomePage.getQuestionSevenPanelText(driver);
        HomePage.assertQuestionSevenTextExpectedActual(textActual);

        HomePage.clickQuestionEightHeading(driver);
        textActual = HomePage.getQuestionEightPanelText(driver);
        HomePage.assertQuestionEightTextExpectedActual(textActual);

    }


    @After
    public void teardown(){
        driver.quit();
    }
}
