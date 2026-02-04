package testvar;

import org.openqa.selenium.By;

public class QuestionsData {

    //Кнопку кук убираем - может мешать тестам
    public static By cookieButton = By.xpath(".//button[@id='rcc-confirm-button']");

    //Заголовки панелей - кликаем по ним и открываем панели
    public static String questionOneHeading = ".//div[@id='accordion__heading-0']";
    public static String questionTwoHeading = ".//div[@id='accordion__heading-1']";
    public static String questionThreeHeading = ".//div[@id='accordion__heading-2']";
    public static String questionFourHeading = ".//div[@id='accordion__heading-3']";
    public static String questionFiveHeading = ".//div[@id='accordion__heading-4']";
    public static String questionSixHeading = ".//div[@id='accordion__heading-5']";
    public static String questionSevenHeading = ".//div[@id='accordion__heading-6']";
    public static String questionEightHeading = ".//div[@id='accordion__heading-7']";

    //Сами панели - считываем текст и сравниваем
    public static String questionOnePanel = ".//div[@id='accordion__panel-0']/p";
    public static String questionTwoPanel = ".//div[@id='accordion__panel-1']/p";
    public static String questionThreePanel = ".//div[@id='accordion__panel-2']/p";
    public static String questionFourPanel = ".//div[@id='accordion__panel-3']/p";
    public static String questionFivePanel = ".//div[@id='accordion__panel-4']/p";
    public static String questionSixPanel = ".//div[@id='accordion__panel-5']/p";
    public static String questionSevenPanel = ".//div[@id='accordion__panel-6']/p";
    public static String questionEightPanel = ".//div[@id='accordion__panel-7']/p";

    //Тексты ответов для сравнения
    public static String questionOneExpectedText = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    public static String questionTwoExpectedText = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
    public static String questionThreeExpectedText = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
    public static String questionFourExpectedText = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
    public static String questionFiveExpectedText = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
    public static String questionSixExpectedText = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
    public static String questionSevenExpectedText = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
    public static String questionEightExpectedText = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";

}
