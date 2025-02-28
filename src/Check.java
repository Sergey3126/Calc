
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Check {
    public boolean result(String example) {
        Pattern pattern = Pattern.compile("[+\\-*^()|/]");
        Matcher matcher = pattern.matcher(example);
        return matcher.find();//наличие оператора
    }

    public void checkExpression(String example) {

        String operators = "+-*/^";
        for (int i = 0; i < example.length(); i++) {
            char c = example.charAt(i);

            // Проверка на недопустимые символы
            if (!Character.isDigit(c) && !operators.contains(String.valueOf(c))) {
                System.out.println("Неразрешенные символы");
                System.exit(0);
            }
            // Проверка на наличие рядом стоящих операторов (кроме минуса перед числом)
            if (operators.contains(String.valueOf(c))) {
                if (i > 0 && operators.contains(String.valueOf(example.charAt(i - 1)))) {
                    // Если текущий символ - оператор и предыдущий символ тоже оператор
                    // НО: нужно исключить случай, когда минус стоит перед числом (например, "-5")
                    // Проверяем, не является ли минус первым символом или стоящим после открывающей скобки (если бы они были)
                    if (c == '-' && (i == 0 || example.charAt(i - 1) == '(')) {
                        //Это допустимый минус перед числом
                    } else {
                        System.out.println("Недопустимая последовательность операторов");
                        System.exit(0);
                    }
                }
            }
        }
    }

}
