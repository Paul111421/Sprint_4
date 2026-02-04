//Пометка - данные идут по списку дополнительных тестов согласно информации со страницы проекта

package testvar;

import org.openqa.selenium.By;

public class FacultyData {

    //Локаторы лого и проверок открытия сайтов
    public static By samokatLogo = By.xpath(".//a[@class='Header_LogoScooter__3lsAR']");
    public static By samokatHomePage = By.xpath(".//div[@class='Home_FirstPart__3g6vG']");

    public static By yandexLogo = By.xpath(".//a[@class='Header_LogoYandex__3TSOI']");
    public static String yandexHomePage = "https://dzen.ru/?yredirect=true";

    //Проверка сообщений об ошибке в форме - в тесте используются локаторы полей из OrderData, чтобы не повторяться,
    //потому здесь только локаторы и тексты именно ошибок. Начинаем с первой страницы формы
    public static By formErrorLocatorName = By.xpath(".//div[@class='Input_InputContainer__3NykH'][1]/div[@class='Input_ErrorMessage__3HvIb Input_Visible___syz6']");
    public static By formErrorLocatorFamilyName = By.xpath(".//div[@class='Input_InputContainer__3NykH'][2]/div");
    public static By formErrorLocatorAddress = By.xpath(".//div[@class='Input_InputContainer__3NykH'][3]/div");
    public static By formErrorLocatorMetro = By.xpath(".//div[@class='Order_MetroError__1BtZb']");
    public static By formErrorLocatorTelephone = By.xpath(".//div[@class='Input_InputContainer__3NykH'][4]/div");


    public static String formErrorTextNameExpected = "Введите корректное имя";
    public static String formErrorTextFamilyNameExpected = "Введите корректную фамилию";
    public static String formErrorTextAddressExpected = "Введите корректный адрес";
    public static String formErrorTextMetroExpected = "Выберите станцию";
    public static String formErrorTextTelephoneExpected = "Введите корректный номер";
    //Во второй странице формы в дереве ничего не нашёл по ошибкам, только непонятное "Тут что-то не так". Пропускаю...

    public static By statusHeaderButton = By.xpath(".//button[@class='Header_Link__1TAG7']");
    public static By statusHeaderInputBar = By.xpath(".//input[@class='Input_Input__1iN_Z Header_Input__xIoUq']");
    public static String statusHeaderInputBarWrongData = "Ятестерстопроц";
    public static By statusHeaderGoButton = By.xpath(".//button[@class='Button_Button__ra12g Header_Button__28dPO']");
    //Для проверки отсутствия экрана статуса используем узел из OrderData
}
