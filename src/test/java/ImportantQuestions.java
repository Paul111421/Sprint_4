//Низ страницы
//8 вопросов на проверку
//Проверка - нажать на вопрос и сравнить ответы

import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import testvar.QuestionsData;

@RunWith(Parameterized.class)
public class ImportantQuestions {

    private WebDriver driver;

    private final String questionHeadingXpath;
    private final String questionPanelXpath;
    private final String textExpected;

    public ImportantQuestions(String questionHeadingXpath, String questionPanelXpath, String textExpected){
        this.questionHeadingXpath = questionHeadingXpath;
        this.questionPanelXpath = questionPanelXpath;
        this.textExpected = textExpected;
    }

    @Parameterized.Parameters
    public static Object[][] getImportantQuestionsData(){
        return new Object[][]{
                {QuestionsData.questionOneHeading, QuestionsData.questionOnePanel, QuestionsData.questionOneExpectedText},
                {QuestionsData.questionTwoHeading, QuestionsData.questionTwoPanel, QuestionsData.questionTwoExpectedText},
                {QuestionsData.questionThreeHeading, QuestionsData.questionThreePanel, QuestionsData.questionThreeExpectedText},
                {QuestionsData.questionFourHeading, QuestionsData.questionFourPanel, QuestionsData.questionFourExpectedText},
                {QuestionsData.questionFiveHeading, QuestionsData.questionFivePanel, QuestionsData.questionFiveExpectedText},
                {QuestionsData.questionSixHeading, QuestionsData.questionSixPanel, QuestionsData.questionSixExpectedText},
                {QuestionsData.questionSevenHeading, QuestionsData.questionSevenPanel, QuestionsData.questionSevenExpectedText},
                {QuestionsData.questionEightHeading, QuestionsData.questionEightPanel, QuestionsData.questionEightExpectedText},
        };
    }

    @Test
    public void questionTestFirefox(){

        String textActual;

        System.setProperty("webdriver.gecko.driver","/home/vdwv/WebDriver/bin/geckodriver");
        driver = new FirefoxDriver();

        driver.get("https://qa-scooter.praktikum-services.ru/");

        driver.findElement(QuestionsData.cookieButton).click();

        WebElement stationElement = driver.findElement(By.xpath(questionHeadingXpath));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", stationElement);

        driver.findElement(By.xpath(questionHeadingXpath)).click();
        textActual = driver.findElement(By.xpath(questionPanelXpath)).getText();
        Assert.assertEquals(textExpected, textActual);
    }


    @Test
    public void questionTestChromium(){

        String textActual;

        System.setProperty("webdriver.chrome.driver", "/home/vdwv/WebDriver/bin/chromedriver-linux64/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/usr/bin/google-chrome-stable");
        driver = new ChromeDriver(options);


        driver.get("https://qa-scooter.praktikum-services.ru/");

        driver.findElement(QuestionsData.cookieButton).click();

        WebElement stationElement = driver.findElement(By.xpath(questionHeadingXpath));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", stationElement);

        driver.findElement(By.xpath(questionHeadingXpath)).click();
        textActual = driver.findElement(By.xpath(questionPanelXpath)).getText();
        Assert.assertEquals(textExpected, textActual);
    }

    @After
    public void teardown(){
        driver.quit();
    }
}
