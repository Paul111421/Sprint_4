package testvar;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    //Убираем кнопку кук - мешает отдельным тестам
    private final static By COOKIE_BUTTON = By.xpath(".//button[@id='rcc-confirm-button']");
    public static void clickCookieButton(WebDriver driver) {driver.findElement(COOKIE_BUTTON).click();}

    private final static By SAMOKAT_LOGO = By.xpath(".//a[@class='Header_LogoScooter__3lsAR']");
    public static void clickSamokatLogo(WebDriver driver) {driver.findElement(SAMOKAT_LOGO).click();}
    private final static By SAMOKAT_HOMEPAGE = By.xpath(".//div[@class='Home_FirstPart__3g6vG']");
    public static void assertHomePageAfterClickingOnSamokatLogo(WebDriver driver){
        WebElement homePage = driver.findElement(SAMOKAT_HOMEPAGE);
        Assert.assertTrue("Домашняя страница не открылась", homePage.isDisplayed());
    }

    private final static By YANDEX_LOGO = By.xpath(".//a[@class='Header_LogoYandex__3TSOI']");
    private final static String YANDEX_HOME_PAGE = "https://dzen.ru/?yredirect=true";
    public static void clickYandexLogo(WebDriver driver) {driver.findElement(YANDEX_LOGO).click();}
    public static void assertYandexUrl(WebDriver driver){
        Boolean didYandexHomePage = new WebDriverWait(driver, 15)
                .until(ExpectedConditions.urlToBe(YANDEX_HOME_PAGE));
        Assert.assertTrue("Домашняя страница не открылась", didYandexHomePage);
    }

    //Кнопки заказа
    private final static String ORDER_BUTTON_HEADER = ".//button[@class='Button_Button__ra12g']";
    public static String getOrderButtonHeader() {return ORDER_BUTTON_HEADER;}

    private final static String ORDER_BUTTON_BOTTOM = ".//div[@class='Home_FinishButton__1_cWm']/button";
    public static String getOrderButtonBottom() {return ORDER_BUTTON_BOTTOM;}

    public static void clickOrderButton (WebDriver driver, String orderButton) {
        driver.findElement(By.xpath(orderButton)).click();
    }

    //Кнопка и поле статуса и действия с ними
    private final static By STATUS_HEADER_BUTTON = By.xpath(".//button[@class='Header_Link__1TAG7']");
    public static void clickStatusHeaderButton(WebDriver driver){
        driver.findElement(STATUS_HEADER_BUTTON).click();
    }

    private final static By STATUS_HEADER_INPUT_BAR = By.xpath(".//input[@class='Input_Input__1iN_Z Header_Input__xIoUq']");
    private final static String STATUS_HEADER_INPUT_BAR_WRONG_DATA = "Ятестерстопроц";
    public static void fillStatusHeaderInputBarWithWrongData(WebDriver driver){
        driver.findElement(STATUS_HEADER_INPUT_BAR).sendKeys(STATUS_HEADER_INPUT_BAR_WRONG_DATA);
    }

    private final static By STATUS_HEADER_GO_BUTTON = By.xpath(".//button[@class='Button_Button__ra12g Header_Button__28dPO']");
    public static void clickStatusHeaderGoButton(WebDriver driver){
        driver.findElement(STATUS_HEADER_GO_BUTTON).click();
    }

    //Заголовки панелей - кликаем по ним и открываем панели
    private final static By QUESTION_ONE_HEADING = By.xpath(".//div[@id='accordion__heading-0']");
    private final static By QUESTION_ONE_PANEL = By.xpath(".//div[@id='accordion__panel-0']/p");
    private final static String QUESTION_ONE_EXPECTED_TEXT = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    public static void clickQuestionOneHeading (WebDriver driver) {driver.findElement(QUESTION_ONE_HEADING).click();}
    public static String getQuestionOnePanelText(WebDriver driver) {return driver.findElement(QUESTION_ONE_PANEL).getText();}
    public static void assertQuestionOneTextExpectedActual (String textActual) {
        Assert.assertEquals(QUESTION_ONE_EXPECTED_TEXT, textActual);
    }

    private final static By QUESTION_TWO_HEADING = By.xpath(".//div[@id='accordion__heading-1']");
    private final static By QUESTION_TWO_PANEL = By.xpath(".//div[@id='accordion__panel-1']/p");
    private final static String QUESTION_TWO_EXPECTED_TEXT = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
    public static void clickQuestionTwoHeading (WebDriver driver) {driver.findElement(QUESTION_TWO_HEADING).click();}
    public static String getQuestionTwoPanelText(WebDriver driver) {return driver.findElement(QUESTION_TWO_PANEL).getText();}
    public static void assertQuestionTwoTextExpectedActual (String textActual) {
        Assert.assertEquals(QUESTION_TWO_EXPECTED_TEXT, textActual);
    }

    private final static By QUESTION_THREE_HEADING = By.xpath(".//div[@id='accordion__heading-2']");
    private final static By QUESTION_THREE_PANEL = By.xpath(".//div[@id='accordion__panel-2']/p");
    private final static String QUESTION_THREE_EXPECTED_TEXT = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
    public static void clickQuestionThreeHeading (WebDriver driver) {driver.findElement(QUESTION_THREE_HEADING).click();}
    public static String getQuestionThreePanelText(WebDriver driver) {return driver.findElement(QUESTION_THREE_PANEL).getText();}
    public static void assertQuestionThreeTextExpectedActual (String textActual) {
        Assert.assertEquals(QUESTION_THREE_EXPECTED_TEXT, textActual);
    }

    private final static By QUESTION_FOUR_HEADING = By.xpath(".//div[@id='accordion__heading-3']");
    private final static By QUESTION_FOUR_PANEL = By.xpath(".//div[@id='accordion__panel-3']/p");
    private final static String QUESTION_FOUR_EXPECTED_TEXT = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
    public static void clickQuestionFourHeading (WebDriver driver) {driver.findElement(QUESTION_FOUR_HEADING).click();}
    public static String getQuestionFourPanelText(WebDriver driver) {return driver.findElement(QUESTION_FOUR_PANEL).getText();}
    public static void assertQuestionFourTextExpectedActual (String textActual) {
        Assert.assertEquals(QUESTION_FOUR_EXPECTED_TEXT, textActual);
    }

    private final static By QUESTION_FIVE_HEADING = By.xpath(".//div[@id='accordion__heading-4']");
    private final static By QUESTION_FIVE_PANEL = By.xpath(".//div[@id='accordion__panel-4']/p");
    private final static String QUESTION_FIVE_EXPECTED_TEXT = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
    public static void clickQuestionFiveHeading (WebDriver driver) {driver.findElement(QUESTION_FIVE_HEADING).click();}
    public static String getQuestionFivePanelText(WebDriver driver) {return driver.findElement(QUESTION_FIVE_PANEL).getText();}
    public static void assertQuestionFiveTextExpectedActual (String textActual) {
        Assert.assertEquals(QUESTION_FIVE_EXPECTED_TEXT, textActual);
    }

    private final static By QUESTION_SIX_HEADING = By.xpath(".//div[@id='accordion__heading-5']");
    private final static By QUESTION_SIX_PANEL = By.xpath(".//div[@id='accordion__panel-5']/p");
    private final static String QUESTION_SIX_EXPECTED_TEXT = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
    public static void clickQuestionSixHeading (WebDriver driver) {driver.findElement(QUESTION_SIX_HEADING).click();}
    public static String getQuestionSixPanelText(WebDriver driver) {return driver.findElement(QUESTION_SIX_PANEL).getText();}
    public static void assertQuestionSixTextExpectedActual (String textActual) {
        Assert.assertEquals(QUESTION_SIX_EXPECTED_TEXT, textActual);
    }


    private final static By QUESTION_SEVEN_HEADING = By.xpath(".//div[@id='accordion__heading-6']");
    private final static By QUESTION_SEVEN_PANEL = By.xpath(".//div[@id='accordion__panel-6']/p");
    private final static String QUESTION_SEVEN_EXPECTED_TEXT = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
    public static void clickQuestionSevenHeading (WebDriver driver) {driver.findElement(QUESTION_SEVEN_HEADING).click();}
    public static String getQuestionSevenPanelText(WebDriver driver) {return driver.findElement(QUESTION_SEVEN_PANEL).getText();}
    public static void assertQuestionSevenTextExpectedActual (String textActual) {
        Assert.assertEquals(QUESTION_SEVEN_EXPECTED_TEXT, textActual);
    }


    private final static By QUESTION_EIGHT_HEADING = By.xpath(".//div[@id='accordion__heading-7']");
    private final static By QUESTION_EIGHT_PANEL = By.xpath(".//div[@id='accordion__panel-7']/p");
    private final static String QUESTION_EIGHT_EXPECTED_TEXT = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";
    public static void clickQuestionEightHeading (WebDriver driver) {driver.findElement(QUESTION_EIGHT_HEADING).click();}
    public static String getQuestionEightPanelText(WebDriver driver) {return driver.findElement(QUESTION_EIGHT_PANEL).getText();}
    public static void assertQuestionEightTextExpectedActual (String textActual) {
        Assert.assertEquals(QUESTION_EIGHT_EXPECTED_TEXT, textActual);
    }

}
