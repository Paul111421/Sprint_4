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

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import testvar.HomePage;
import testvar.OrderPage;
import testvar.StatusPage;


@RunWith(Parameterized.class)
public class OrderForm {

    private WebDriver driver;

    private final String browserName;//Добавил переменную, через параметризацию задаём разные драйвера до тестов
    private final String orderButton; //важно в рамках теста - узлы кнопок в xpath!!
    private final String userName;
    private final String userFamilyName;
    private final String address;
    private final String metroStation;
    private final String telephone;
    private final String date;

    public OrderForm(String browserName, String orderButton, String userName, String userFamilyName, String address, String metroStation,
                     String telephone, String date){
        this.browserName = browserName;
        this.orderButton = orderButton;
        this.userName = userName;
        this.userFamilyName = userFamilyName;
        this.address = address;
        this.metroStation = metroStation;
        this.telephone = telephone;
        this.date = date;
    }

    @Parameterized.Parameters (name = "{0}, {2}")
    public static Object[][] getOrderFormData(){
        return new Object[][]{
                {"firefox", HomePage.getOrderButtonHeader(),"Михаил","Булгаков", //Кнопка формы в хэдере
                        "г. Москва, Большая Садовая, д. 10, 1 этаж",
                        OrderPage.getMetroMayakovskaya(),
                        "+74959700619", "02.02.2026"},

                {"firefox", HomePage.getOrderButtonBottom(),"Олег","Парастаев", //Нижняя кнопка формы
                        "г. Москва, р-н Арбат, ул. Воздвиженка, 3",
                        OrderPage.getMetroLenina(),
                        "+78001005790", "02.02.2026"},

                {"chrome", HomePage.getOrderButtonHeader(),"Михаил","Булгаков", //Кнопка формы в хэдере
                        "г. Москва, Большая Садовая, д. 10, 1 этаж",
                        OrderPage.getMetroMayakovskaya(),
                        "+74959700619", "02.02.2026"},

                {"chrome", HomePage.getOrderButtonBottom(),"Олег","Парастаев", //Нижняя кнопка формы
                        "г. Москва, р-н Арбат, ул. Воздвиженка, 3",
                        OrderPage.getMetroLenina(),
                        "+78001005790", "02.02.2026"}
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
    public void formTest() {

        HomePage.clickCookieButton(driver); //убираем куки - второй тест глохнет
        HomePage.clickOrderButton(driver, orderButton);

        //Вводим первые данные
        OrderPage.fillUserNameInput(driver, userName);
        OrderPage.fillUserFamilyNameInput(driver, userFamilyName);
        OrderPage.fillAddressInput(driver, address);
        OrderPage.fillMetroInput(driver, metroStation);
        OrderPage.fillTelephoneInput(driver, telephone);
        OrderPage.clickButtonNextFormPage(driver);

        //Второе окно данных - дата и длительность аренды
        OrderPage.fillDateInput(driver, date);
        OrderPage.clickRentDuration(driver);
        OrderPage.clickSecondFormPageOrderButton(driver);
        OrderPage.clickOrderConfirmButton(driver);

        //Ждём появления окошка с номером заказа, смотрим его статус
        OrderPage.getOrderConfirmedWindow(driver);
        OrderPage.clickCheckStatusButton(driver);
        StatusPage.assertOrderStatusScreen(driver);
    }

    @After
    public void teardown(){
        driver.quit();
    }
}
