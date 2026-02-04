//Заголовок страницы
//Кнопка "Заказать"
//Заполнить поля формы: "Имя", "Фамилия", "Адрес", "Станция метро" (кликать!), "Телефон"
//Кнопка "Далее"
//Заполнить обязательные поля: "Когда привезти самокат" (можно ввести цифры), "Срок аренды" (кликать отдельным методом!)
//Кнопка "Заказать"
//Окно "Хотите оформить заказ?"
//Кнопка "Да"
//Форма "Заказ оформлен"
//Кнопка "Посмотреть заказ"
//Открывается страница заказа

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import testvar.OrderData;


@RunWith(Parameterized.class)
public class OrderForm {

    private WebDriver driver;

    private final String orderButton; //важно в рамках теста - узлы кнопок в xpath!!
    private final String userName;
    private final String userFamilyName;
    private final String address;
    private final String metroStation;
    private final String telephone;
    private final String date;

    public OrderForm(String orderButton, String userName, String userFamilyName, String address, String metroStation,
                     String telephone, String date){
        this.orderButton = orderButton;
        this.userName = userName;
        this.userFamilyName = userFamilyName;
        this.address = address;
        this.metroStation = metroStation;
        this.telephone = telephone;
        this.date = date;
    }

    @Parameterized.Parameters
    public static Object[][] getOrderFormData(){
        return new Object[][]{
                {OrderData.orderButtonHeader,"Михаил","Булгаков", //Кнопка формы в хэдере
                        "г. Москва, Большая Садовая, д. 10, 1 этаж",
                        OrderData.metroMayakovskaya,
                        "+74959700619", "02.02.2026"},

                {OrderData.orderButtonBottom,"Олег","Парастаев", //Нижняя кнопка формы
                        "г. Москва, р-н Арбат, ул. Воздвиженка, 3",
                        OrderData.metroLenina,
                        "+78001005790", "02.02.2026"}
        };
    }

    public void clickMetroStation(){
        driver.findElement(OrderData.metroInput).click();
        new WebDriverWait(driver, 2) //Точно тут. Список не прокручивается даже на Файрфоксе, какие узлы я не выбирал бы...
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//button[@value='1']")));
        WebElement stationElement = driver.findElement(By.xpath(metroStation));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", stationElement);
        stationElement.click();
    }

    public void clickRentDuration(){
        driver.findElement(OrderData.dropdownArrow).click();
        driver.findElement(OrderData.dropdownOptionDay).click();
    }

    @Test
    public void formTestFirefox() throws InterruptedException {

        System.setProperty("webdriver.gecko.driver","/home/vdwv/WebDriver/bin/geckodriver");
        driver = new FirefoxDriver();

        driver.get("https://qa-scooter.praktikum-services.ru/");

        //Вводим первые данные
        driver.findElement(OrderData.cookieButton).click(); //убираем куки - второй тест глохнет
        driver.findElement(By.xpath(orderButton)).click();
        driver.findElement(OrderData.userNameInput).sendKeys(userName);
        driver.findElement(OrderData.userFamilyNameInput).sendKeys(userFamilyName);
        driver.findElement(OrderData.addressInput).sendKeys(address);
        clickMetroStation();
        driver.findElement(OrderData.telephoneInput).sendKeys(telephone);
        driver.findElement(OrderData.buttonNextFormPage).click();
        new WebDriverWait(driver, 1)
                .until(ExpectedConditions.presenceOfElementLocated(OrderData.dateInput));
        //Вводим аренду самоката
        driver.findElement(OrderData.dateInput).sendKeys(date);
        clickRentDuration();
        driver.findElement(OrderData.secondFormPageOrderButton).click();
        driver.findElement(OrderData.orderConfirm).click();

        //Ждём появления окошка с номером заказа, смотрим его статус
        new WebDriverWait(driver, 1)
                .until(ExpectedConditions.presenceOfElementLocated(OrderData.orderConfirmedWindow));
        driver.findElement(OrderData.checkStatusButton).click();
        new WebDriverWait(driver, 5).until(ExpectedConditions.presenceOfElementLocated(OrderData.orderStatusScreen));
    }

    @Test
    public void formTestChromium() {

        System.setProperty("webdriver.chrome.driver", "/home/vdwv/WebDriver/bin/chromedriver-linux64/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/usr/bin/google-chrome-stable");
        driver = new ChromeDriver(options);

        driver.get("https://qa-scooter.praktikum-services.ru/");

        //Вводим первые данные
        driver.findElement(OrderData.cookieButton).click(); //убираем куки - второй тест глохнет
        driver.findElement(By.xpath(orderButton)).click();
        driver.findElement(OrderData.userNameInput).sendKeys(userName);
        driver.findElement(OrderData.userFamilyNameInput).sendKeys(userFamilyName);
        driver.findElement(OrderData.addressInput).sendKeys(address);
        clickMetroStation();
        driver.findElement(OrderData.telephoneInput).sendKeys(telephone);
        driver.findElement(OrderData.buttonNextFormPage).click();
        new WebDriverWait(driver, 1)
                .until(ExpectedConditions.presenceOfElementLocated(OrderData.dateInput));
        //Вводим аренду самоката
        driver.findElement(OrderData.dateInput).sendKeys(date);
        clickRentDuration();
        driver.findElement(OrderData.secondFormPageOrderButton).click();
        driver.findElement(OrderData.orderConfirm).click();

        //Ждём появления окошка с номером заказа, смотрим его статус
        new WebDriverWait(driver, 1)
                .until(ExpectedConditions.presenceOfElementLocated(OrderData.orderConfirmedWindow));

        driver.findElement(OrderData.checkStatusButton).click(); //Дайте угадаю, тут баг в Хроме? Файрфокс этот же самый код идеально читает и выполняет, зелёная галка даже

        new WebDriverWait(driver, 3).until(ExpectedConditions.presenceOfElementLocated(OrderData.orderStatusScreen));
    }

    @After
    public void Teardown(){
        driver.quit();
    }
}
