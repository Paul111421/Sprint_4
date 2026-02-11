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
    private final static String ORDER_BUTTON_HEADER = ".//button[@class='Button_Button__ra12g']";
    private final static String ORDER_BUTTON_BOTTOM = ".//div[@class='Home_FinishButton__1_cWm']/button";

    //Кнопка и поле статуса
    private final static By STATUS_HEADER_BUTTON = By.xpath(".//button[@class='Header_Link__1TAG7']");
    private final static By STATUS_HEADER_INPUT_BAR = By.xpath(".//input[@class='Input_Input__1iN_Z Header_Input__xIoUq']");
    private final static String STATUS_HEADER_INPUT_BAR_WRONG_DATA = "Ятестерстопроц";

    //Элементы панелей
    private final static By QUESTION_ONE_HEADING = By.xpath(".//div[@id='accordion__heading-0']");
    private final static By QUESTION_ONE_PANEL = By.xpath(".//div[@id='accordion__panel-0']/p");
    private final static String QUESTION_ONE_EXPECTED_TEXT = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";

    private final static By QUESTION_TWO_HEADING = By.xpath(".//div[@id='accordion__heading-1']");
    private final static By QUESTION_TWO_PANEL = By.xpath(".//div[@id='accordion__panel-1']/p");
    private final static String QUESTION_TWO_EXPECTED_TEXT = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";

    private final static By QUESTION_THREE_HEADING = By.xpath(".//div[@id='accordion__heading-2']");
    private final static By QUESTION_THREE_PANEL = By.xpath(".//div[@id='accordion__panel-2']/p");
    private final static String QUESTION_THREE_EXPECTED_TEXT = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";

    private final static By QUESTION_FOUR_HEADING = By.xpath(".//div[@id='accordion__heading-3']");
    private final static By QUESTION_FOUR_PANEL = By.xpath(".//div[@id='accordion__panel-3']/p");
    private final static String QUESTION_FOUR_EXPECTED_TEXT = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";

    private final static By QUESTION_FIVE_HEADING = By.xpath(".//div[@id='accordion__heading-4']");
    private final static By QUESTION_FIVE_PANEL = By.xpath(".//div[@id='accordion__panel-4']/p");
    private final static String QUESTION_FIVE_EXPECTED_TEXT = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";

    private final static By QUESTION_SIX_HEADING = By.xpath(".//div[@id='accordion__heading-5']");
    private final static By QUESTION_SIX_PANEL = By.xpath(".//div[@id='accordion__panel-5']/p");
    private final static String QUESTION_SIX_EXPECTED_TEXT = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";

    private final static By QUESTION_SEVEN_HEADING = By.xpath(".//div[@id='accordion__heading-6']");
    private final static By QUESTION_SEVEN_PANEL = By.xpath(".//div[@id='accordion__panel-6']/p");
    private final static String QUESTION_SEVEN_EXPECTED_TEXT = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";

    private final static By QUESTION_EIGHT_HEADING = By.xpath(".//div[@id='accordion__heading-7']");
    private final static By QUESTION_EIGHT_PANEL = By.xpath(".//div[@id='accordion__panel-7']/p");
    private final static String QUESTION_EIGHT_EXPECTED_TEXT = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";

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
    public static String getOrderButtonHeader() {return ORDER_BUTTON_HEADER;}

    public static String getOrderButtonBottom() {return ORDER_BUTTON_BOTTOM;}

    public static void clickOrderButton (WebDriver driver, String orderButton) {
        driver.findElement(By.xpath(orderButton)).click();
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
    public static void clickQuestionHeading (WebDriver driver, By questionHeading) {
        driver.findElement(questionHeading).click();
    }
    public static String getQuestionPanelText(WebDriver driver, By questionPanel) {
        return driver.findElement(questionPanel).getText();
    }
    public static void assertQuestionTextExpectedActual (String questionTextExpected, String questionTextActual) {
        Assert.assertEquals(questionTextExpected, questionTextActual);
    }

    public static By getQuestionOneHeading () {
        return QUESTION_ONE_HEADING;
    }
    public static By getQuestionOnePanel() {
        return QUESTION_ONE_PANEL;
    }
    public static String getQuestionOneTextExpected () {
        return QUESTION_ONE_EXPECTED_TEXT;
    }

    public static By getQuestionTwoHeading () {
        return QUESTION_TWO_HEADING;
    }
    public static By getQuestionTwoPanel() {
        return QUESTION_TWO_PANEL;
    }
    public static String getQuestionTwoTextExpected () {
        return QUESTION_TWO_EXPECTED_TEXT;
    }

    public static By getQuestionThreeHeading () {
        return QUESTION_THREE_HEADING;
    }
    public static By getQuestionThreePanel() {
        return QUESTION_THREE_PANEL;
    }
    public static String getQuestionThreeTextExpected () {
        return QUESTION_THREE_EXPECTED_TEXT;
    }

    public static By getQuestionFourHeading () {
        return QUESTION_FOUR_HEADING;
    }
    public static By getQuestionFourPanel() {
        return QUESTION_FOUR_PANEL;
    }
    public static String getQuestionFourTextExpected () {
        return QUESTION_FOUR_EXPECTED_TEXT;
    }

    public static By getQuestionFiveHeading () {
        return QUESTION_FIVE_HEADING;
    }
    public static By getQuestionFivePanel() {
        return QUESTION_FIVE_PANEL;
    }
    public static String getQuestionFiveTextExpected () {
        return QUESTION_FIVE_EXPECTED_TEXT;
    }

    public static By getQuestionSixHeading () {
        return QUESTION_SIX_HEADING;
    }
    public static By getQuestionSixPanel() {
        return QUESTION_SIX_PANEL;
    }
    public static String getQuestionSixTextExpected () {
        return QUESTION_SIX_EXPECTED_TEXT;
    }

    public static By getQuestionSevenHeading () {
        return QUESTION_SEVEN_HEADING;
    }
    public static By getQuestionSevenPanel() {
        return QUESTION_SEVEN_PANEL;
    }
    public static String getQuestionSevenTextExpected () {
        return QUESTION_SEVEN_EXPECTED_TEXT;
    }

    public static By getQuestionEightHeading () {
        return QUESTION_EIGHT_HEADING;
    }
    public static By getQuestionEightPanel() {
        return QUESTION_EIGHT_PANEL;
    }
    public static String getQuestionEightTextExpected () {
        return QUESTION_EIGHT_EXPECTED_TEXT;
    }

}
