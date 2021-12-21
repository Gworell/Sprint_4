package ru.praktikum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class AccountParametrizedTest {
    private final String testName;
    private final boolean expectedResult;

    public AccountParametrizedTest(String testName, boolean expectedResult) {
        this.testName = testName;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Object[][] getResult() {
        return new Object[][]{
                {"Тимоти Шаламе", true},
                {"Т Ш", true},
                {"Тимоти Шаламеаааааа", true},
                {"Тимоти Шаламеааааааа", false},
                {" Тимоти Шаламе", false},
                {"Тимоти Шаламе ", false},
                {"Тимоти  Шаламе", false},
                {"ТимотиШаламе", false},
                {"Ти", false},
                {"%№:%", false}
        };
    }

    @Test
    public void checkNameToEmbossTest() {
        Account account = new Account(testName);
        boolean actualResult = account.checkNameToEmboss();
        assertEquals(expectedResult, actualResult);
    }
}