import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalcMain {
    public static void main(String[] args) {
        Operator operator = new Operator();
        Check check = new Check();
        Arithmetic arithmetic = new Arithmetic();
        Limiters limiters = new Limiters();
        List<Character> operations = Arrays.asList('(', '|', ')');
        Pattern pattern = Pattern.compile("[+\\-*^()|/]");


       //-((2 ^ 3) + (100 - (5 * (3 + 2)))) / (2 + 3) - (15 - (2 ^ (2 + (10 / 5))))+((10 + 2) * (3 - 1)) ^ 2 / 4 + (2 * (5 + (3 ^ 2) - (12 / 3)))
        String expression = "|(2+|3-1|)*2^2/|5+(1-2)||+|(2+|3-1|)*|5+(1-2)|| " ;
        expression = expression.replaceAll("[\\n\\s]", "");//убирает пробел и обзац
        check.checkExpression(expression);//проверка
        System.out.println(expression);
        boolean areOperators = true;
        while (areOperators) {//счет пока есть операторы
            Matcher matcher = pattern.matcher(expression);
            areOperators =  matcher.find();//наличие операторов


            if (operator.checkOperatorPriority(expression, operations)) {
                if (expression.indexOf('(')!=-1||expression.indexOf('|')!=-1){
                    expression = limiters.limiters(expression);
                }
            } else {
                expression = arithmetic.arithmetic(expression);
            }
            System.out.println(expression);
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