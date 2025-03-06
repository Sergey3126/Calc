import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class CalculatorWithMathCopyMain {
    public static void main(String[] args) {
        Operator operator = new Operator();
        Check check = new Check();
        Arithmetic arithmetic = new Arithmetic();
        Limiters limiters = new Limiters();
        List<Character> operations = Arrays.asList('(', '|', ')');
        Pattern pattern = Pattern.compile("[+\\-*^()|/]");

//        String example;
//        while (true){
//            System.out.println("Введите пример");
//            System.out.println("Для помощи введите-Помощь");
//         example = scanner.next();
//        if (example.toLowerCase().equals("помощь")) {
 //       System.out.println("Запрещено: 1.Буквы 2.Несколько операторов подряд(Нельзя:10++10.Можно: ввод отрицательного числа(Пример: 10+-5 или 10+(-5))). Обязательно закрывать скобки. \nСписок доступных операторов: 1.+(сложение) 2.-(вычитание) 3.*(умножить) 4./(деление) 5.^(степень) 6.()(скобки)");
//        }else {
//            break;
//        }}
       //-((2 ^ 3) + (100 - (5 * (3 + 2)))) / (2 + 3) - (15 - (2 ^ (2 + (10 / 5))))+((10 + 2) * (3 - 1)) ^ 2 / 4 + (2 * (5 + (3 ^ 2) - (12 / 3)))
        String example = "||6-5|+(|10-5|-|10+10|)|" ;
        example = example.replaceAll("[\\n\\s]", "");//убирает пробел и обзац
        check.checkExpression(example);//проверка
        System.out.println(example);

        while (check.result(example, pattern)) {//счет пока есть операторы

            if (operator.checkOperatorPriority(example, operations)) {
                if (example.indexOf('(')!=-1){
                    example = limiters.brackets(example);
                } else if (example.indexOf('|')!=-1){
                    example = limiters.module(example);
                }
            } else {
                example = arithmetic.arithmetic(example);
            }
            System.out.println(example);
        }
   //     System.out.println(example);
    }
}
/*
1.Ищу оператор с высшим приоритетом
2.Ищу числа по бокам
2.1 Левым ограничителем является некий оператор(или не цифра)
2.2 Правым ограничителем является некий оператор(или не цифра)
3 Счита выражение
4 Результат заменяю выражением
 */