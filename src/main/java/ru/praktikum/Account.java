package ru.praktikum;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Account {

    private final String name;

    public Account(String name) {
        this.name = name;
    }
    /*
       Этот метод должен проверять, что сохранённая через конструктор строка соответствует требованиям.
       Если строка удовлетворяет условиям, метод возвращает true, иначе — false.
   */
    private static final String USERNAME_PATTERN = "(?=.{3,19}$)[а-яА-Яa-zA-z]+\\s{1}[а-яА-Яa-zA-z]+";
    private static final Pattern pattern = Pattern.compile(USERNAME_PATTERN);

    public boolean checkNameToEmboss() {
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }
}
