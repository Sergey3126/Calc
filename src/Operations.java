
import java.util.Arrays;
import java.util.List;

public class Operations {
    public String arithmetic(String example) {
        CalculatorWithMathCopy calc = new CalculatorWithMathCopy();
        StringBuilder sb = new StringBuilder(example);
        List<Character> operations = Arrays.asList('^', '*', '/', '+', '-');
        String result = "";
        int indexStart = Integer.MAX_VALUE;
        int indexEnd = Integer.MAX_VALUE;
        int indexOperation = 0;
        int operation = 0;
        double num1 = 0;
        double num2 = 0;
        for (int i = 0; i < operations.size(); i++) {
            if (example.indexOf(operations.get(i)) != -1) {
                if (i == 1 || i == 3) {
                    if (example.indexOf(operations.get(i + 1)) < example.indexOf(operations.get(i)) && example.indexOf(operations.get(i + 1)) != -1) {
                        operation = i + 1;
                        indexOperation = example.indexOf(operations.get(i + 1));
                        break;
                    }
                } else if (i == 2 || i == 4) {
                    if (example.indexOf(operations.get(i - 1)) < example.indexOf(operations.get(i)) && example.indexOf(operations.get(i - 1)) != -1) {
                        operation = i - 1;
                        indexOperation = example.indexOf(operations.get(i - 1));
                        break;
                    }
                }
                operation = i;
                indexOperation = example.indexOf(operations.get(i));
                break;//ищет операторы

            }
        }

        for (int i = indexOperation - 1; i >= 0; i--) {//начало примера
            for (int j = 0; j < operations.size(); j++) {
                if (i == 0 || i == example.length() - 1) {//если начало или конец
                    indexStart = i;
                    break;
                } else if (example.charAt(i) == operations.get(j)) {
                    indexStart = i + 1;
                    break;
                }

            }
            if (indexStart != Integer.MAX_VALUE) {
                break;
            }
        }

        for (int i = indexOperation + 1; i < example.length(); i++) {//конец примера
            for (int j = 0; j < operations.size(); j++) {
                if (i == 0 || i == example.length() - 1) {//если начало или конец
                    indexEnd = i;
                    break;
                } else if (example.charAt(i) == operations.get(j)) {
                    indexEnd = i - 1;
                    break;
                }
            }
            if (indexEnd != Integer.MAX_VALUE) {
                break;
            }
        }

        if (indexOperation != -1) {//перевод и счет
            try {
                String num = example.substring(indexStart, indexOperation);
                num1 = Double.parseDouble(num);
                num = example.substring(indexOperation + 1, indexEnd + 1);
                num2 = Double.parseDouble(num);
            }catch (NumberFormatException e){
                System.err.println("Что-то пошло не так. Возможно не корректный ввод. Повторите попытку");
                return "";
            }
            try {
                switch (operations.get(operation)) {
                    case '+':
                        result = String.valueOf(calc.sum(num1, num2));
                        break;
                    case '-':
                        result = String.valueOf(calc.minus(num1, num2));
                        break;
                    case '*':
                        result = String.valueOf(calc.multiplication(num1, num2));
                        break;
                    case '/':
                        result = String.valueOf(calc.division(num1, num2));
                        break;
                    case '^':
                        int num3 = (int) num2;
                        result = String.valueOf(calc.pow(num1, num3));
                        break;
                }
            }catch (ArithmeticException e){
                System.err.println("Что-то пошло не так. Возможно не корректный пример. Повторите попытку");
                return "";
            }
            sb.replace(indexStart, indexEnd + 1, result);
            String str = sb.toString();
            return str;
        } else {
            return example;
        }

    }
}