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

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import testvar.HomePage;
import testvar.OrderPage;
import testvar.StatusPage;


@RunWith(Parameterized.class)
public class OrderForm extends BaseTest{

    //Добавил переменную, через параметризацию задаём разные драйвера до тестов
    private final String orderButton; //важно в рамках теста - узлы кнопок в xpath!!
    private final String userName;
    private final String userFamilyName;
    private final String address;
    private final String metroStation;
    private final String telephone;
    private final String date;

    public OrderForm(String browserName, String orderButton, String userName, String userFamilyName, String address, String metroStation,
                     String telephone, String date){
        super(browserName);
        this.orderButton = orderButton;
        this.userName = userName;
        this.userFamilyName = userFamilyName;
        this.address = address;
        this.metroStation = metroStation;
        this.telephone = telephone;
        this.date = date;
    }

    @Parameterized.Parameters (name = "{0}, {1}")
    public static Object[][] getOrderFormData(){
        return new Object[][]{
                {"firefox", "Верхняя кнопка заказа","Михаил","Булгаков", //Кнопка формы в хэдере
                        "г. Москва, Большая Садовая, д. 10, 1 этаж",
                        "Метро Маяковская",
                        "+74959700619", "02.02.2026"},

                {"firefox", "Нижняя кнопка заказа","Олег","Парастаев", //Нижняя кнопка формы
                        "г. Москва, р-н Арбат, ул. Воздвиженка, 3",
                        "Библиотека имени Ленина",
                        "+78001005790", "02.02.2026"},

                {"chrome", "Верхняя кнопка заказа","Михаил","Булгаков", //Кнопка формы в хэдере
                        "г. Москва, Большая Садовая, д. 10, 1 этаж",
                        "Метро Маяковская",
                        "+74959700619", "02.02.2026"},

                {"chrome", "Нижняя кнопка заказа","Олег","Парастаев", //Нижняя кнопка формы
                        "г. Москва, р-н Арбат, ул. Воздвиженка, 3",
                        "Библиотека имени Ленина",
                        "+78001005790", "02.02.2026"}
        };
    }



    @Test
    public void formTest() {

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


}
