import java.util.Arrays;
import java.util.List;

public class Arithmetic {
    public String arithmetic(String example) {
        Operator operator = new Operator();
        CalculatorWithMathCopy calc = new CalculatorWithMathCopy();
        StringBuilder sb = new StringBuilder(example);
        Index index = new Index();
        String result = "";
        double num1 = 0;
        double num2 = 0;
        List<Character> operators = Arrays.asList('*', '/', '+', '-', '^');//доступные операторы
        List<Character> operations = operator.checkOperator(example);//первые операторы
        int indexOperation = index.indexOperation(example, operations);
        int indexStart = index.indexStart(example, indexOperation, operators);
        int indexEnd = index.indexEnd(example, indexOperation, operators);
        if (indexOperation != -1) {
            try {//перевод числа
                String num = example.substring(indexStart, indexOperation);
                num1 = Double.parseDouble(num);
                num = example.substring(indexOperation + 1, indexEnd + 1);
                num2 = Double.parseDouble(num);
            } catch (Exception e) {
                System.err.println("Ошибка счета");
                System.exit(0);
            }
            switch (example.charAt(indexOperation)) {
                case '+':
                    result = String.valueOf(calc.sum(num1, num2));
                    break;
                case '-':
                    result = String.valueOf(calc.minus(num1, num2));
                    break;
            }
            switch (example.charAt(indexOperation)) {
                case '*':
                    result = String.valueOf(calc.multiplication(num1, num2));
                    break;
                case '/':
                    result = String.valueOf(calc.division(num1, num2));
                    break;
            }
            switch (example.charAt(indexOperation)) {
                case '^':
                    int num3 = (int) num2;
                    result = String.valueOf(calc.pow(num1, num3));
                    break;
            }
            sb.replace(indexStart, indexEnd + 1, result);
            String str = sb.toString();
            return str;
        } else {
            return example;
        }

    }
}
