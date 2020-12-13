package comVISh;

public class ClassPrint {


    //Метод выводит (слова) минус

    public static void print_minus(String slovo1, String slovo2) {
        String result =   slovo1.replace(slovo2,"");


        print_value(result);
    }

    //Метод выводит (слова) сумма

    public static void print_summa(String slovo1, String slovo2) {
        String result =   slovo1 + ""+slovo2;


        print_value(result);
    }
    //Метод выводит (цифрам) умножение

    public static void print_umnohenie(String slovo1, int slovo2) {
        String result = "";
        for (int i=0;i<slovo2;i++)
        {
            result = result+""+slovo1;
        }

        print_value(result);
    }
    //Метод выводит (цифрам) деление

    public static void print_delenie(String slovo1, int slovo2) {
        String result = slovo1.substring(0, slovo2);


        print_value(result);
    }

    //метод выводит на экран значение в кавычках
    public static void print_value(String value) {

        if (value.length() >= 40)
        {


            String result = "\"" + value.substring(0,40) + "...\"";
            System.out.println(result);
        }
        else {
            if (value.trim().length() == 0)
            {
               print_error("Ошибка. Не найдены значения");
            }
            else
            {
                String result = "\"" + value + "\"";
                System.out.println(result);
            }
        }
    }


    public static void print_error(String error)
    {
        System.out.println(error);
    }

}
