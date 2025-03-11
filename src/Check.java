import operatorsPriority.AllOperators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Check {
    private AllOperators allOperators = new AllOperators();


    /**
     * проверка на наличие
     *
     * @param expression
     * @param pattern
     * @return
     */

    public boolean result(String expression, Pattern pattern) {
        Matcher matcher = pattern.matcher(expression);
        return matcher.find();//наличие операторов
    }


    /**
     * Проверка на правильность ввода
     *
     * @param expression
     */
    public String checkExpression(String expression) {
        String operators = allOperators.getAllOperatorsString(); // разрешенные операторы
        String limiters = "()|";    // разрешенные ограничители
        int brackets = 0; // Счетчик скобок
        int modules = 0;   // Счетчик модуля
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            // Проверка на недопустимые символы
            if (!Character.isDigit(c) && !operators.contains(String.valueOf(c)) && !limiters.contains(String.valueOf(c))) {
                return "Неразрешенные символы: " + c;
            }
            // Проверка на наличие рядом стоящих операторов
            if (operators.contains(String.valueOf(c))) {
                if (i > 0 && operators.contains(String.valueOf(expression.charAt(i - 1))) || i == 0 && operators.contains(String.valueOf(expression.charAt(i)))) {
                    if (c != '-') {
                        return "Недопустимая последовательность операторов";

                    }
                }
            }

            // Обработка скобок
            if (c == '(') {
                brackets++;
            } else if (c == ')') {
                brackets--;
            }

            // Проверка баланса скобок
            if (brackets < 0) {
                return "Закрывающая скобка раньше открывающей";
            }

            // Проверка на несбалансированные скобки
            if (brackets != 0) {
                return "Не совпадает количество открывающих и закрывающих скобок";

            }

            // Обработка символов модуля
            if (c == '|') {
                modules++;
            }
        }

        // Проверка на нечетное количество символов модуля
        if (modules % 2 != 0) {
            return "Непарное количество символов модуля";
        }


        return "";
    }

}
