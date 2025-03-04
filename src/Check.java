import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Check {


    /**
     *  проверка на наличие
     * @param example
     * @param pattern
     * @return
     */
    public boolean result(String example, Pattern pattern) {
        Matcher matcher = pattern.matcher(example);
        return matcher.find();//наличие операторов
    }



    /**
     * Проверка на правильность ввода
     * @param example
     */
    public void checkExpression(String example) {
        String operators = "+-*/^"; // разрешенные операторы
        String limiters = "()|";    // разрешенные ограничители
        int brackets = 0; // Счетчик скобок
        int modules = 0;   // Счетчик модуля
        for (int i = 0; i < example.length(); i++) {
            char c = example.charAt(i);
            // Проверка на недопустимые символы
            if (!Character.isDigit(c) && !operators.contains(String.valueOf(c)) && !limiters.contains(String.valueOf(c))) {
                System.out.println("Неразрешенные символы: " + c);
                System.exit(0);
            }
            // Проверка на наличие рядом стоящих операторов
            if (operators.contains(String.valueOf(c))) {
                if (i > 0 && operators.contains(String.valueOf(example.charAt(i - 1))) || i == 0 && operators.contains(String.valueOf(example.charAt(i)))) {
                    if (c != '-') {
                        System.out.println("Недопустимая последовательность операторов");
                        System.exit(0);
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
                System.out.println("Закрывающая скобка раньше открывающей");
                System.exit(0);
            }

            // Обработка символов модуля
            if (c == '|') {
                modules++;
            }
        }

        // Проверка на нечетное количество символов модуля
        if (modules % 2 != 0) {
            System.out.println("Непарное количество символов модуля");
            System.exit(0);
        }

        // Проверка на несбалансированные скобки
        if (brackets != 0) {
            System.out.println("Не совпадает количество открывающих и закрывающих скобок");
            System.exit(0);
        }
    }

}
