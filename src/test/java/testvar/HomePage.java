package testvar;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private final static String SAMOKAT_URL = "https://qa-scooter.praktikum-services.ru/";

    //Убираем кнопку кук - мешает отдельным тестам
    private final static By COOKIE_BUTTON = By.xpath(".//button[@id='rcc-confirm-button']");

    private final static By SAMOKAT_LOGO = By.xpath(".//a[@class='Header_LogoScooter__3lsAR']");
    private final static By SAMOKAT_HOMEPAGE = By.xpath(".//div[@class='Home_FirstPart__3g6vG']");

    private final static By YANDEX_LOGO = By.xpath(".//a[@class='Header_LogoYandex__3TSOI']");
    private final static String YANDEX_HOME_PAGE = "https://dzen.ru/?yredirect=true";

    //Кнопки заказа
    private final static By ORDER_BUTTON_HEADER = By.xpath(".//button[@class='Button_Button__ra12g']");
    private final static By ORDER_BUTTON_BOTTOM = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button");

    //Кнопка и поле статуса
    private final static By STATUS_HEADER_BUTTON = By.xpath(".//button[@class='Header_Link__1TAG7']");
    private final static By STATUS_HEADER_INPUT_BAR = By.xpath(".//input[@class='Input_Input__1iN_Z Header_Input__xIoUq']");
    private final static String STATUS_HEADER_INPUT_BAR_WRONG_DATA = "Ятестерстопроц";

    //Элементы панелей
    private final static By QUESTION_ONE_HEADING = By.xpath(".//div[@id='accordion__heading-0']");
    private final static By QUESTION_ONE_PANEL = By.xpath(".//div[@id='accordion__panel-0']/p");

    private final static By QUESTION_TWO_HEADING = By.xpath(".//div[@id='accordion__heading-1']");
    private final static By QUESTION_TWO_PANEL = By.xpath(".//div[@id='accordion__panel-1']/p");

    private final static By QUESTION_THREE_HEADING = By.xpath(".//div[@id='accordion__heading-2']");
    private final static By QUESTION_THREE_PANEL = By.xpath(".//div[@id='accordion__panel-2']/p");

    private final static By QUESTION_FOUR_HEADING = By.xpath(".//div[@id='accordion__heading-3']");
    private final static By QUESTION_FOUR_PANEL = By.xpath(".//div[@id='accordion__panel-3']/p");

    private final static By QUESTION_FIVE_HEADING = By.xpath(".//div[@id='accordion__heading-4']");
    private final static By QUESTION_FIVE_PANEL = By.xpath(".//div[@id='accordion__panel-4']/p");

    private final static By QUESTION_SIX_HEADING = By.xpath(".//div[@id='accordion__heading-5']");
    private final static By QUESTION_SIX_PANEL = By.xpath(".//div[@id='accordion__panel-5']/p");

    private final static By QUESTION_SEVEN_HEADING = By.xpath(".//div[@id='accordion__heading-6']");
    private final static By QUESTION_SEVEN_PANEL = By.xpath(".//div[@id='accordion__panel-6']/p");

    private final static By QUESTION_EIGHT_HEADING = By.xpath(".//div[@id='accordion__heading-7']");
    private final static By QUESTION_EIGHT_PANEL = By.xpath(".//div[@id='accordion__panel-7']/p");

    public static String getSamokatUrl (){
        return SAMOKAT_URL;
    }

    public static void clickCookieButton(WebDriver driver) {driver.findElement(COOKIE_BUTTON).click();}

    //Проверка открытия домашней страницы Самоката при нажатии на лого Самоката
    public static void clickSamokatLogo(WebDriver driver) {driver.findElement(SAMOKAT_LOGO).click();}
    public static void assertHomePageAfterClickingOnSamokatLogo(WebDriver driver){
        WebElement homePage = driver.findElement(SAMOKAT_HOMEPAGE);
        Assert.assertTrue("Домашняя страница не открылась", homePage.isDisplayed());
    }

    //Проверка открытия домашней страницы Яндекса
    public static void clickYandexLogo(WebDriver driver) {driver.findElement(YANDEX_LOGO).click();}
    public static void assertYandexUrl(WebDriver driver){
        Boolean didYandexHomePage = new WebDriverWait(driver, 15)
                .until(ExpectedConditions.urlToBe(YANDEX_HOME_PAGE));
        Assert.assertTrue("Домашняя страница не открылась", didYandexHomePage);
    }

    //Кнопки оформления заказа

    public static void clickOrderButton (WebDriver driver, String orderButton) {
        if ("Верхняя кнопка заказа".equals(orderButton)){
            driver.findElement(ORDER_BUTTON_HEADER).click();
        } else if ("Нижняя кнопка заказа".equals(orderButton)) {
            driver.findElement(ORDER_BUTTON_BOTTOM).click();
        }
    }

    //Проверка статуса заказа
    public static void clickStatusHeaderButton(WebDriver driver){
        driver.findElement(STATUS_HEADER_BUTTON).click();
    }
    public static void fillStatusHeaderInputBarWithWrongData(WebDriver driver){
        driver.findElement(STATUS_HEADER_INPUT_BAR).sendKeys(STATUS_HEADER_INPUT_BAR_WRONG_DATA);
    }
    private final static By STATUS_HEADER_GO_BUTTON = By.xpath(".//button[@class='Button_Button__ra12g Header_Button__28dPO']");
    public static void clickStatusHeaderGoButton(WebDriver driver){
        driver.findElement(STATUS_HEADER_GO_BUTTON).click();
    }

    //Проверка "Вопросов о важном"
    public static String getQuestionNumberTextActual(WebDriver driver, String questionNumber) {

        By questionHeading = null;
        By questionPanel = null;

        switch (questionNumber) {
            case ("Вопрос 1"):
                questionHeading = QUESTION_ONE_HEADING;
                questionPanel = QUESTION_ONE_PANEL;
                break;
            case ("Вопрос 2"):
                questionHeading = QUESTION_TWO_HEADING;
                questionPanel = QUESTION_TWO_PANEL;
                break;
            case ("Вопрос 3"):
                questionHeading = QUESTION_THREE_HEADING;
                questionPanel = QUESTION_THREE_PANEL;
                break;
            case ("Вопрос 4"):
                questionHeading = QUESTION_FOUR_HEADING;
                questionPanel = QUESTION_FOUR_PANEL;
                break;
            case ("Вопрос 5"):
                questionHeading = QUESTION_FIVE_HEADING;
                questionPanel = QUESTION_FIVE_PANEL;
                break;
            case ("Вопрос 6"):
                questionHeading = QUESTION_SIX_HEADING;
                questionPanel = QUESTION_SIX_PANEL;
                break;
            case ("Вопрос 7"):
                questionHeading = QUESTION_SEVEN_HEADING;
                questionPanel = QUESTION_SEVEN_PANEL;
                break;
            case ("Вопрос 8"):
                questionHeading = QUESTION_EIGHT_HEADING;
                questionPanel = QUESTION_EIGHT_PANEL;
                break;
        }
        driver.findElement(questionHeading).click();
        return driver.findElement(questionPanel).getText();
    }

    public static void assertQuestionTextExpectedActual (String questionTextExpected, String questionTextActual) {
        Assert.assertEquals(questionTextExpected, questionTextActual);
    }
}
