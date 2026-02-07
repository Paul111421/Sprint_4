package testvar;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderPage {

    //Поля ввода данных пользователя, личные данные
    private final static By USER_NAME_INPUT = By.xpath(".//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN' and @placeholder='* Имя']");

    public static void fillUserNameInput(WebDriver driver, String userName) {
        driver.findElement(USER_NAME_INPUT).sendKeys(userName);
    }

    private final static By USER_FAMILY_NAME_INPUT = By.xpath(".//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN' and @placeholder='* Фамилия']");

    public static void fillUserFamilyNameInput(WebDriver driver, String userFamilyName) {
        driver.findElement(USER_FAMILY_NAME_INPUT).sendKeys(userFamilyName);
    }

    private final static By ADDRESS_INPUT = By.xpath(".//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN' and @placeholder='* Адрес: куда привезти заказ']");

    public static void fillAddressInput(WebDriver driver, String address) {
        driver.findElement(ADDRESS_INPUT).sendKeys(address);
    }

    //Отдельно - кнопки метро
    private final static By METRO_INPUT = By.xpath(".//input[@class='select-search__input']");

    public static void fillMetroInput(WebDriver driver, String metroStation) {
        driver.findElement(METRO_INPUT).click();
        new WebDriverWait(driver, 2)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//button[@value='1']")));
        WebElement stationElement = driver.findElement(By.xpath(metroStation));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", stationElement);
        stationElement.click();
    }

    private final static String METRO_MAYAKOVSKAYA = ".//button[@value='30']";

    public static String getMetroMayakovskaya() {
        return METRO_MAYAKOVSKAYA;
    }

    private final static String METRO_LENINA = ".//button[@value='11']";

    public static String getMetroLenina() {
        return METRO_LENINA;
    }

    private final static By TELEPHONE_INPUT = By.xpath(".//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN' and @placeholder='* Телефон: на него позвонит курьер']");

    public static void fillTelephoneInput(WebDriver driver, String telephone) {
        driver.findElement(TELEPHONE_INPUT).sendKeys(telephone);
    }

    //Поля ввода данных пользователя, аренда самоката когда и сколько
    private final static By DATE_INPUT = By.xpath(".//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN' and @placeholder='* Когда привезти самокат']");

    public static void fillDateInput(WebDriver driver, String date) {
        new WebDriverWait(driver, 1)
                .until(ExpectedConditions.presenceOfElementLocated(DATE_INPUT));
        //Вводим аренду самоката
        driver.findElement(DATE_INPUT).sendKeys(date);
    }

    //Кнопки на формах
    //Кнопка перехода к данным аренды самоката
    private final static By BUTTON_NEXT_FORM_PAGE = By.xpath(".//div[@class='Order_NextButton__1_rCA']/button");

    public static void clickButtonNextFormPage(WebDriver driver) {
        driver.findElement(BUTTON_NEXT_FORM_PAGE).click();
    }

    //Кнопки выбора срока аренды и "Заказать" с подтверждением
    private final static By DROPDOWN_ARROW = By.xpath(".//span");

    private final static By DROPDOWN_OPTION_DAY = By.xpath(".//div[@class='Dropdown-option' and text()='сутки']");

    public static void clickRentDuration(WebDriver driver) {
        driver.findElement(DROPDOWN_ARROW).click();
        driver.findElement(DROPDOWN_OPTION_DAY).click();
    }

    private final static By SECOND_FORM_PAGE_ORDER_BUTTON = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    public static void clickSecondFormPageOrderButton(WebDriver driver) {
        driver.findElement(SECOND_FORM_PAGE_ORDER_BUTTON).click();
    }

    private final static By ORDER_CONFIRM_BUTTON = By.xpath(".//div[@class='Order_Modal__YZ-d3']/div[@class='Order_Buttons__1xGrp']/button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    public static void clickOrderConfirmButton(WebDriver driver) {
        driver.findElement(ORDER_CONFIRM_BUTTON).click();
    }

    private final static By ORDER_CONFIRMED_WINDOW = By.xpath(".//div[@class='Order_Modal__YZ-d3']");

    public static void getOrderConfirmedWindow(WebDriver driver) {
        new WebDriverWait(driver, 1)
                .until(ExpectedConditions.presenceOfElementLocated(ORDER_CONFIRMED_WINDOW));
    }

    private final static By CHECK_STATUS_BUTTON = By.xpath(".//div[@class='Order_Modal__YZ-d3']/div[@class='Order_NextButton__1_rCA']/button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    public static void clickCheckStatusButton(WebDriver driver) {
        driver.findElement(CHECK_STATUS_BUTTON).click();
    }

    //Локаторы ошибок заполнения, их содержания и методы работы с ними
    private final static By FORM_ERROR_LOCATOR_NAME = By.xpath(".//div[@class='Input_InputContainer__3NykH'][1]/div[@class='Input_ErrorMessage__3HvIb Input_Visible___syz6']");
    private final static String FORM_ERROR_TEXT_NAME_EXPECTED = "Введите корректное имя";
    public static void waitForFormErrorName(WebDriver driver){
        new WebDriverWait(driver, 1)
                .until(ExpectedConditions.presenceOfElementLocated(FORM_ERROR_LOCATOR_NAME));
    }
    public static String getFormErrorNameTextActual(WebDriver driver){
        return driver.findElement(FORM_ERROR_LOCATOR_NAME).getText();
    }
    public static void assertFormErrorNameText(String textActual){
        Assert.assertEquals(FORM_ERROR_TEXT_NAME_EXPECTED, textActual);
    }

    private final static By FORM_ERROR_LOCATOR_FAMILY_NAME = By.xpath(".//div[@class='Input_InputContainer__3NykH'][2]/div");
    private final static String FORM_ERROR_TEXT_FAMILY_NAME_EXPECTED = "Введите корректную фамилию";
    public static String getFormErrorFamilyNameTextActual(WebDriver driver){
        return driver.findElement(FORM_ERROR_LOCATOR_FAMILY_NAME).getText();
    }
    public static void assertFormErrorFamilyNameText(String textActual){
        Assert.assertEquals(FORM_ERROR_TEXT_FAMILY_NAME_EXPECTED, textActual);
    }

    private final static By FORM_ERROR_LOCATOR_ADDRESS = By.xpath(".//div[@class='Input_InputContainer__3NykH'][3]/div");
    private final static String FORM_ERROR_TEXT_ADDRESS_EXPECTED = "Введите корректный адрес";
    public static String getFormErrorAddressTextActual(WebDriver driver){
        return driver.findElement(FORM_ERROR_LOCATOR_ADDRESS).getText();
    }
    public static void assertFormErrorAddressText(String textActual){
        Assert.assertEquals(FORM_ERROR_TEXT_ADDRESS_EXPECTED, textActual);
    }

    private final static By FORM_ERROR_LOCATOR_METRO = By.xpath(".//div[@class='Order_MetroError__1BtZb']");
    private final static String FORM_ERROR_TEXT_METRO_EXPECTED = "Выберите станцию";
    public static String getFormErrorMetroTextActual(WebDriver driver){
        return driver.findElement(FORM_ERROR_LOCATOR_METRO).getText();
    }
    public static void assertFormErrorMetroText(String textActual){
        Assert.assertEquals(FORM_ERROR_TEXT_METRO_EXPECTED, textActual);
    }

    private final static By FORM_ERROR_LOCATOR_TELEPHONE = By.xpath(".//div[@class='Input_InputContainer__3NykH'][4]/div");
    private final static String FORM_ERROR_TEXT_TELEPHONE_EXPECTED = "Введите корректный номер";
    public static String getFormErrorTelephoneTextActual(WebDriver driver){
        return driver.findElement(FORM_ERROR_LOCATOR_TELEPHONE).getText();
    }
    public static void assertFormErrorTelephoneText(String textActual){
        Assert.assertEquals(FORM_ERROR_TEXT_TELEPHONE_EXPECTED, textActual);
    }

}
