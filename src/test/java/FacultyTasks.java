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

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Test;
import testvar.HomePage;
import testvar.StatusPage;

import static testvar.OrderPage.*;

import java.util.Set;


@RunWith(Parameterized.class)
public class FacultyTasks extends BaseTest{

    public FacultyTasks(String browserName){
        super(browserName);
    }

    @Parameterized.Parameters(name = "{0}")
    public static Object[][] getImportantQuestionsData(){
        return new Object[][]{
                {"firefox"},
                {"chrome"},
        };
    }


    @Test
    public void logoSamokat(){

        HomePage.clickOrderButton(driver, HomePage.getOrderButtonHeader());
        HomePage.clickSamokatLogo(driver);
        HomePage.assertHomePageAfterClickingOnSamokatLogo(driver);

    }


    public void switchToNewWindowIfOpened() {

        // Получаем текущее количество окон
        Set<String> originalWindow = driver.getWindowHandles();

        HomePage.clickYandexLogo(driver);

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

        HomePage.assertYandexUrl(driver);
    }

    //Очень странно - открывается вкладка, а засчитывает за окно... Или всё же опечатка или тут окно есть вкладка?
    //Оставляю пока так. По доке numberOfWindowsToBe ожидает окна, но считает вкладки...

    @Test
    public void logoYandex(){ //Очень странно - открывается вкладка, а засчитывает за окно... Или всё же опечатка или тут окно есть вкладка?
        switchToNewWindowIfOpened();
    }

    @Test
    public void formErrorsShow(){

        String formErrorTextNameActual;
        String formErrorTextFamilyNameActual;
        String formErrorTextAddressActual;
        String formErrorTextMetroActual;
        String formErrorTextTelephoneActual;

        HomePage.clickOrderButton(driver, HomePage.getOrderButtonHeader());
        clickButtonNextFormPage(driver);

        waitForFormErrorName(driver);
        formErrorTextNameActual  = getFormErrorNameTextActual(driver);
        formErrorTextFamilyNameActual = getFormErrorFamilyNameTextActual(driver);
        formErrorTextAddressActual = getFormErrorAddressTextActual(driver);
        formErrorTextMetroActual = getFormErrorMetroTextActual(driver);
        formErrorTextTelephoneActual = getFormErrorTelephoneTextActual(driver);

        assertFormErrorNameText(formErrorTextNameActual);
        assertFormErrorFamilyNameText(formErrorTextFamilyNameActual);
        assertFormErrorAddressText(formErrorTextAddressActual);
        assertFormErrorMetroText(formErrorTextMetroActual);
        assertFormErrorTelephoneText(formErrorTextTelephoneActual);
    }

    @Test
    public void wrongOrderNumberSearch(){

        HomePage.clickStatusHeaderButton(driver);
        HomePage.fillStatusHeaderInputBarWithWrongData(driver);
        HomePage.clickStatusHeaderGoButton(driver);
        StatusPage.assertWrongOrderStatusScreen(driver);

    }

}