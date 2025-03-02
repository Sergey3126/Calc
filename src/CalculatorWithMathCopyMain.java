import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.regex.Pattern;

public class CalculatorWithMathCopyMain {
    public static void main(String[] args) {
        Operator operator = new Operator();
        Check check = new Check();
        Index index = new Index();
        List<Character> operations = Arrays.asList('(', '|');
        Pattern pattern1 = Pattern.compile("[+\\-*^()|/]");
        Pattern pattern2 = Pattern.compile("[+*^()|/]");
//        String example;
//        while (true){
//            System.out.println("Введите пример");
//            System.out.println("Для помощи введите-Помощь");
//         example = scanner.next();
//        if (example.toLowerCase().equals("помощь")) {
//            System.out.println("Запрещены буквы. Список доступных операторов: 1.+(сложение) 2.-(вычитание) 3.*(умножить) 4./(деление) 5.^(степень)");
//        }else {
//            break;
//        }}
        String example = "-10+5";
        example = example.replaceAll("[\\n\\s]", "");//убирает пробел и обзац
        check.checkExpression(example);
        System.out.println(example);

        while (check.result(example, pattern1)) {
            if (!check.result(example,pattern2)){
                break;
            }
            if (operator.operatorPriority(example, operations)) {
                int openIndex = example.lastIndexOf('(');
                int closeIndex = example.indexOf(')',openIndex);
                String newExample = example.substring(openIndex + 1, closeIndex);
                while (check.result(newExample, pattern1)) {
                    newExample = operator.arithmetic(newExample);
                }
                StringBuilder sb = new StringBuilder(example);
                sb.replace(openIndex, closeIndex + 1, newExample);
                example = sb.toString();
            } else {
                example = operator.arithmetic(example);
            }

            System.out.println(example);
        }
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