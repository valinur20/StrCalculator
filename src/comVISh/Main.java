package comVISh;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        ClassAnaliz classAnaliz = new ClassAnaliz(); //Подключаем класс для анализа и вывода на экран


        Scanner console = new Scanner(System.in);
        String value = console.nextLine();

        classAnaliz.analiz_value(value);

    }
}