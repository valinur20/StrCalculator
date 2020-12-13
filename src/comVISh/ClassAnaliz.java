package comVISh;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClassAnaliz {
ClassPrint classPrint;

  public void analiz_value(String value) {
      classPrint = new ClassPrint();


      if (!value.substring(0,1).equals("\"")) {
          classPrint.print_error("Первое значение должно быть указано в кавычках");

      }
      else
      {


      Pattern pattern = Pattern.compile("\"(.*?)\""); //Подготовка регулярного выражчения
      Matcher m = pattern.matcher(value); //Получаем отдельно слова в кавычках
      int count_naideno_slov = 0; //счётчик, сколько слов найдено
      String slovo1 = "";
      String slovo2 = "";
      while (m.find())  //Перебираем слова
      {
          count_naideno_slov++; //Увеличиваем счётчик на +1

          if (count_naideno_slov == 1)  //
          {
              slovo1 = m.group(1).trim();
          }
          if (count_naideno_slov == 2) {
              slovo2 = m.group(1).trim();
          }
      }
     // System.out.println("Слово 1  : " + slovo1);
     //System.out.println("Слово 2  : " + slovo2);
      //System.out.println("count_naideno_slov  : " + count_naideno_slov);
     // if (   (slovo1.equals("")))
  //    {
       //   classPrint.print_error("Ошибка. Слово 1 не найдено");
   //   }
     // else {

          if (slovo2.equals("")) //Второе слово не найдено кавычках, возможно это цифра
          {
              String tmp_slovo1 = "\"" + slovo1 + "\"";
              String ostatok = value.replace(tmp_slovo1, "").trim();
              // System.out.println("Остаток (цифра): " + ostatok);

              if (ostatok.indexOf("/") != -1) //Найден символ /
              {
                  String[] arValue = ostatok.split("/"); //Получаем в переменную arValue[1] цифру
                  if (proverka_len(1, arValue[1])) {
                      //System.out.println("Второе значение: " + arValue[1]);
                      classPrint.print_delenie(slovo1, Integer.parseInt(arValue[1].trim()));
                  } else {
                      classPrint.print_error("Второе значение, цифра может быть от 1 до 10.");
                  }
                  //     System.out.println("Остаток (деление): "+arValue[1]);
              } else {
                  if (ostatok.indexOf("*") != -1) //
                  {
                      String[] arValue = ostatok.split("\\*"); //Получаем в переменную arValue[1] цифру

                      if (proverka_len(1, arValue[1])) {
                          //System.out.println("Второе значение: " + arValue[1]);
                          classPrint.print_umnohenie(slovo1, Integer.parseInt(arValue[1].trim()));
                      } else {
                          classPrint.print_error("Второе значение, цифра может быть от 1 до 10.");
                      }
                  } else {
                      //error =
                      classPrint.print_error("Ошибка. Не найден символ * или /");
                  }
              }

          } else //Найдено два слова в кавычках
          {
              String tmp_slovo1 = "\"" + slovo1 + "\"";
              String tmp_slovo2 = "\"" + slovo2 + "\"";
              String tmp3 = value.replace(tmp_slovo1, "").trim();
              String ostatok = tmp3.replace(tmp_slovo2, "").trim();


              if (ostatok.indexOf("+") != -1) //Найден +
              {
                  if ((proverka_len(0, slovo1)) && (proverka_len(0, slovo2))) {
                      classPrint.print_summa(slovo1, slovo2);
                  } else {
                      classPrint.print_error("Слова не могут быть длиннее 10 символов.");
                  }
              } else {
                  if (ostatok.indexOf("-") != -1) //Найден -
                  {
                      if ((proverka_len(0, slovo1)) && (proverka_len(0, slovo2))) {
                          classPrint.print_minus(slovo1, slovo2);
                      } else {
                          classPrint.print_error("Слова не могут быть длиннее 10 символов.");
                      }


                  } else {
                      classPrint.print_error("Ошибка. Между словами должен быть знак + или -");
                  }
              }


              //System.out.println("Остаток (слова): " + ostatok);
          }


          ////  System.out.println("Слово 1: " + slovo1);
          // System.out.println("Слово 2: " + slovo2);
          //System.out.println("Счётчик: " + count_naideno_slov);

          if (count_naideno_slov > 2) {
              classPrint.print_error("Ошибка, найдено более 2 значений.");
          }
      }


  }


    //Метод проверят длинну каждого слова,
    // возращает true - если условия проходят, иначе false - длинна более 10 символов.
    private static boolean proverka_len(int chifra, String value) {
        value = value.trim();
        if (chifra == 1) //Цирра
        {
            if (Integer.parseInt(value) <= 10) {
                return true;
            } else {
                return false;
            }
        } else //Строка
        {
            if (value.length() <= 10) {
                return true;
            } else {
                return false;
            }
        }


    }

}


