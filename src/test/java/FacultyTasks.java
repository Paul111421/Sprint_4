//1. Тест перехода по логотипу Самоката
//Открыть форму заказа
//Нажать на логотип Самоката и выйти на главную страницу обратно

//2. Тест перехода по логотипу Яндекса
//Нажать на логотип Яндекса
//Выйти на главную страницу поисковика В НОВОМ ОКНЕ (ВАЖНО!! НЕ ВКЛАДКА!)

//3. Проверка кнопок формы
//Я не нашёл в DOM узлов с ошибками на второй странице формы "Про аренду",
//поэтому проверяю только первую страницу "Для кого самокат"
//Открыть форму заказа
//Нажать на кнопку "Далее"
//Сверить сообщения об ошибках с ожидаемыми

//4. Неправильный номер заказа
//Нажать в заголовке страницы "Статус заказа"
//Ввести буквенные значения (для гарантии, вдруг цифрами попадём. Хотя по логике тоже бага...)
//Нажать на кнопку "Go!"
//Перейти на новую страницу
//Проверить, что форма статуса заказа не появилась

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.After;
import org.junit.Test;
import testvar.OrderData;
import testvar.FacultyData;

import java.util.Set;

public class FacultyTasks {

    private WebDriver driver;

    @Test
    public void logoSamokatFirefox(){
        System.setProperty("webdriver.gecko.driver","/home/vdwv/WebDriver/bin/geckodriver");
        driver = new FirefoxDriver();

        driver.get("https://qa-scooter.praktikum-services.ru/");

        driver.findElement(By.xpath(OrderData.orderButtonHeader)).click();
        driver.findElement(FacultyData.samokatLogo).click();
        new WebDriverWait(driver, 1)
                .until(ExpectedConditions.presenceOfElementLocated(FacultyData.samokatHomePage));
    }

    @Test
    public void logoSamokatChromium(){

        System.setProperty("webdriver.chrome.driver", "/home/vdwv/WebDriver/bin/chromedriver-linux64/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/usr/bin/google-chrome-stable");
        driver = new ChromeDriver(options);

        driver.get("https://qa-scooter.praktikum-services.ru/");

        driver.findElement(By.xpath(OrderData.orderButtonHeader)).click();
        driver.findElement(FacultyData.samokatLogo).click();
        new WebDriverWait(driver, 1)
                .until(ExpectedConditions.presenceOfElementLocated(FacultyData.samokatHomePage));
    }

    public void switchToNewWindowIfOpened() {

        driver.get("https://qa-scooter.praktikum-services.ru/");
        // Получаем текущее количество окон
        Set<String> originalWindow = driver.getWindowHandles();

        driver.findElement(FacultyData.yandexLogo).click();

        new WebDriverWait(driver, 15)
                .until(ExpectedConditions.numberOfWindowsToBe(2));

        // Проверяем, появилось ли новое окно
        Set<String> newWindows = driver.getWindowHandles();
        if (newWindows.size() > originalWindow.size()) {
            // Переключаемся на новое окно
            for (String window : newWindows) {
                if (!originalWindow.contains(window)) {
                    driver.switchTo().window(window);
                    break;
                }
            }
        } else {
            System.out.println("Новое окно не открылось");
        }

        new WebDriverWait(driver, 15)
                .until(ExpectedConditions.urlToBe(FacultyData.yandexHomePage));
    }

    //Очень странно - открывается вкладка, а засчитывает за окно... Или всё же опечатка или тут окно есть вкладка?
    //Оставляю пока так. По доке numberOfWindowsToBe ожидает окна, но считает вкладки...

    @Test
    public void logoYandexFirefox(){ //Очень странно - открывается вкладка, а засчитывает за окно... Или всё же опечатка или тут окно есть вкладка?

        System.setProperty("webdriver.gecko.driver","/home/vdwv/WebDriver/bin/geckodriver");
        driver = new FirefoxDriver();

        switchToNewWindowIfOpened();
    }

    @Test
    public void logoYandexChromium(){

        System.setProperty("webdriver.chrome.driver", "/home/vdwv/WebDriver/bin/chromedriver-linux64/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/usr/bin/google-chrome-stable");
        driver = new ChromeDriver(options);

        switchToNewWindowIfOpened();
    }

    @Test
    public void formErrorsShowFirefox(){

        String formErrorTextNameActual;
        String formErrorTextFamilyNameActual;
        String formErrorTextAddressActual;
        String formErrorTextMetroActual;
        String formErrorTextTelephoneActual;

        System.setProperty("webdriver.gecko.driver","/home/vdwv/WebDriver/bin/geckodriver");
        driver = new FirefoxDriver();

        driver.get("https://qa-scooter.praktikum-services.ru/");

        driver.findElement(By.xpath(OrderData.orderButtonHeader)).click();
        driver.findElement(OrderData.buttonNextFormPage).click();

        new WebDriverWait(driver, 1)
                .until(ExpectedConditions.presenceOfElementLocated(FacultyData.formErrorLocatorName));
        formErrorTextNameActual  = driver.findElement(FacultyData.formErrorLocatorName).getText();
        formErrorTextFamilyNameActual = driver.findElement(FacultyData.formErrorLocatorFamilyName).getText();
        formErrorTextAddressActual = driver.findElement(FacultyData.formErrorLocatorAddress).getText();
        formErrorTextMetroActual = driver.findElement(FacultyData.formErrorLocatorMetro).getText();
        formErrorTextTelephoneActual = driver.findElement(FacultyData.formErrorLocatorTelephone).getText();

        Assert.assertEquals(FacultyData.formErrorTextNameExpected, formErrorTextNameActual);
        Assert.assertEquals(FacultyData.formErrorTextFamilyNameExpected, formErrorTextFamilyNameActual);
        Assert.assertEquals(FacultyData.formErrorTextAddressExpected, formErrorTextAddressActual);
        Assert.assertEquals(FacultyData.formErrorTextMetroExpected, formErrorTextMetroActual);
        Assert.assertEquals(FacultyData.formErrorTextTelephoneExpected, formErrorTextTelephoneActual);
    }

    @Test
    public void formErrorsShowChromium(){

        String formErrorTextNameActual;
        String formErrorTextFamilyNameActual;
        String formErrorTextAddressActual;
        String formErrorTextMetroActual;
        String formErrorTextTelephoneActual;

        System.setProperty("webdriver.chrome.driver", "/home/vdwv/WebDriver/bin/chromedriver-linux64/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/usr/bin/google-chrome-stable");
        driver = new ChromeDriver(options);

        driver.get("https://qa-scooter.praktikum-services.ru/");

        driver.findElement(By.xpath(OrderData.orderButtonHeader)).click();
        driver.findElement(OrderData.buttonNextFormPage).click();

        new WebDriverWait(driver, 1)
                .until(ExpectedConditions.presenceOfElementLocated(FacultyData.formErrorLocatorName));
        formErrorTextNameActual  = driver.findElement(FacultyData.formErrorLocatorName).getText();
        formErrorTextFamilyNameActual = driver.findElement(FacultyData.formErrorLocatorFamilyName).getText();
        formErrorTextAddressActual = driver.findElement(FacultyData.formErrorLocatorAddress).getText();
        formErrorTextMetroActual = driver.findElement(FacultyData.formErrorLocatorMetro).getText();
        formErrorTextTelephoneActual = driver.findElement(FacultyData.formErrorLocatorTelephone).getText();

        Assert.assertEquals(FacultyData.formErrorTextNameExpected, formErrorTextNameActual);
        Assert.assertEquals(FacultyData.formErrorTextFamilyNameExpected, formErrorTextFamilyNameActual);
        Assert.assertEquals(FacultyData.formErrorTextAddressExpected, formErrorTextAddressActual);
        Assert.assertEquals(FacultyData.formErrorTextMetroExpected, formErrorTextMetroActual);
        Assert.assertEquals(FacultyData.formErrorTextTelephoneExpected, formErrorTextTelephoneActual);
    }

    @Test
    public void wrongOrderNumberSearchFirefox(){

        System.setProperty("webdriver.gecko.driver","/home/vdwv/WebDriver/bin/geckodriver");
        driver = new FirefoxDriver();

        driver.get("https://qa-scooter.praktikum-services.ru/");

        driver.findElement(FacultyData.statusHeaderButton).click();
        driver.findElement(FacultyData.statusHeaderInputBar).sendKeys(FacultyData.statusHeaderInputBarWrongData);
        driver.findElement(FacultyData.statusHeaderGoButton).click();
        new WebDriverWait(driver, 2)
                .until(ExpectedConditions.invisibilityOfElementLocated(OrderData.orderStatusScreen));
    }

    @Test
    public void wrongOrderNumberSearchChromium(){

        System.setProperty("webdriver.chrome.driver", "/home/vdwv/WebDriver/bin/chromedriver-linux64/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/usr/bin/google-chrome-stable");
        driver = new ChromeDriver(options);

        driver.get("https://qa-scooter.praktikum-services.ru/");

        driver.findElement(FacultyData.statusHeaderButton).click();
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(FacultyData.statusHeaderInputBar));
        driver.findElement(FacultyData.statusHeaderInputBar).sendKeys(FacultyData.statusHeaderInputBarWrongData);
        driver.findElement(FacultyData.statusHeaderGoButton).click();
        new WebDriverWait(driver, 2)
                .until(ExpectedConditions.invisibilityOfElementLocated(OrderData.orderStatusScreen));
    }

    @After
    public void teardown(){
        driver.quit();
    }
}