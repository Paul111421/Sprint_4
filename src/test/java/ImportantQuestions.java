//Низ страницы
//8 вопросов на проверку
//Проверка - нажать на вопрос и сравнить ответы

import org.openqa.selenium.By;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import testvar.HomePage;

@RunWith(Parameterized.class)
public class ImportantQuestions extends BaseTest {

    private final By questionHeading;
    private final By questionPanel;
    private final String questionTextExpected;

    public ImportantQuestions(String browserName, By questionHeading, By questionPanel, String questionTextExpected, String questionNumber){
        super(browserName);
        this.questionHeading = questionHeading;
        this.questionPanel = questionPanel;
        this.questionTextExpected = questionTextExpected;
    }

    @Parameterized.Parameters(name = "{0}, {4}")
    public static Object[][] getImportantQuestionsData(){
        return new Object[][]{
                {"firefox", HomePage.getQuestionOneHeading(), HomePage.getQuestionOnePanel(), HomePage.getQuestionOneTextExpected(), "Вопрос 1"},
                {"firefox", HomePage.getQuestionTwoHeading(), HomePage.getQuestionTwoPanel(), HomePage.getQuestionTwoTextExpected(), "Вопрос 2"},
                {"firefox", HomePage.getQuestionThreeHeading(), HomePage.getQuestionThreePanel(), HomePage.getQuestionThreeTextExpected(), "Вопрос 3"},
                {"firefox", HomePage.getQuestionFourHeading(), HomePage.getQuestionFourPanel(), HomePage.getQuestionFourTextExpected(), "Вопрос 4"},
                {"firefox", HomePage.getQuestionFiveHeading(), HomePage.getQuestionFivePanel(), HomePage.getQuestionFiveTextExpected(), "Вопрос 5"},
                {"firefox", HomePage.getQuestionSixHeading(), HomePage.getQuestionSixPanel(), HomePage.getQuestionSixTextExpected(), "Вопрос 6"},
                {"firefox", HomePage.getQuestionSevenHeading(), HomePage.getQuestionSevenPanel(), HomePage.getQuestionSevenTextExpected(), "Вопрос 7"},
                {"firefox", HomePage.getQuestionEightHeading(), HomePage.getQuestionEightPanel(), HomePage.getQuestionEightTextExpected(), "Вопрос 8"},

                {"chrome", HomePage.getQuestionOneHeading(), HomePage.getQuestionOnePanel(), HomePage.getQuestionOneTextExpected(), "Вопрос 1"},
                {"chrome", HomePage.getQuestionTwoHeading(), HomePage.getQuestionTwoPanel(), HomePage.getQuestionTwoTextExpected(), "Вопрос 2"},
                {"chrome", HomePage.getQuestionThreeHeading(), HomePage.getQuestionThreePanel(), HomePage.getQuestionThreeTextExpected(), "Вопрос 3"},
                {"chrome", HomePage.getQuestionFourHeading(), HomePage.getQuestionFourPanel(), HomePage.getQuestionFourTextExpected(), "Вопрос 4"},
                {"chrome", HomePage.getQuestionFiveHeading(), HomePage.getQuestionFivePanel(), HomePage.getQuestionFiveTextExpected(), "Вопрос 5"},
                {"chrome", HomePage.getQuestionSixHeading(), HomePage.getQuestionSixPanel(), HomePage.getQuestionSixTextExpected(), "Вопрос 6"},
                {"chrome", HomePage.getQuestionSevenHeading(), HomePage.getQuestionSevenPanel(), HomePage.getQuestionSevenTextExpected(), "Вопрос 7"},

        };
    }

    @Test
    public void questionTest(){

        String textActual;

        HomePage.clickCookieButton(driver);

        HomePage.clickQuestionHeading(driver, questionHeading);
        textActual = HomePage.getQuestionPanelText(driver, questionPanel);
        HomePage.assertQuestionTextExpectedActual(questionTextExpected, textActual);

    }

}
