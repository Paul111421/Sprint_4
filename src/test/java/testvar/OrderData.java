package testvar;

import org.openqa.selenium.By;

public class OrderData {
    //Кнопка кук - убираем для нормальной работы второго теста
    public static By cookieButton = By.xpath(".//button[@id='rcc-confirm-button']");

    //Кнопки заказа - в хэдере и снизу
    public static String orderButtonHeader = ".//button[@class='Button_Button__ra12g']";
    public static String orderButtonBottom = ".//div[@class='Home_FinishButton__1_cWm']/button";

    //Поля ввода данных пользователя, личные данные
    public static By userNameInput = By.xpath(".//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN' and @placeholder='* Имя']");
    public static By userFamilyNameInput = By.xpath(".//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN' and @placeholder='* Фамилия']");
    public static By addressInput = By.xpath(".//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN' and @placeholder='* Адрес: куда привезти заказ']");

    //Отдельно - кнопки метро
    public static By metroInput = By.xpath(".//input[@class='select-search__input']");
    public static String metroMayakovskaya = ".//button[@value='30']";
    public static String metroLenina = ".//button[@value='11']";
    public static By telephoneInput = By.xpath(".//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN' and @placeholder='* Телефон: на него позвонит курьер']");
    //Поля ввода данных пользователя, аренда самоката когда и сколько
    public static By dateInput = By.xpath(".//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN' and @placeholder='* Когда привезти самокат']");

    //Кнопки на формах
    //Кнопка перехода к данным аренды самоката
    public static By buttonNextFormPage = By.xpath(".//div[@class='Order_NextButton__1_rCA']/button");

    //Кнопки выбора срока аренды и "Заказать" с подтверждением
    public static By dropdownArrow = By.xpath(".//span");
    public static By dropdownOptionDay = By.xpath(".//div[@class='Dropdown-option' and text()='сутки']");
    public static By secondFormPageOrderButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    public static By orderConfirm = By.xpath(".//div[@class='Order_Modal__YZ-d3']/div[@class='Order_Buttons__1xGrp']/button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    public static By orderConfirmedWindow = By.xpath(".//div[@class='Order_Modal__YZ-d3']");
    public static By checkStatusButton = By.xpath(".//div[@class='Order_Modal__YZ-d3']/div[@class='Order_NextButton__1_rCA']/button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    public static By orderStatusScreen = By.xpath(".//div[@class='Track_OrderColumns__2r_1F']");

}
