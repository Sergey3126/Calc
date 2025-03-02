
import java.util.*;

public class Operator {
    public String arithmetic(String example) {
        CalculatorWithMathCopy calc = new CalculatorWithMathCopy();
        StringBuilder sb = new StringBuilder(example);
        Index index = new Index();
        String result = "";
        double num1 = 0;
        double num2 = 0;
        List<Character> operator = Arrays.asList('*', '/', '+', '-', '^');
        List<Character> operations = checkOperator(example);
        int indexOperation = index.indexOperation(example, operations);
        int indexStart = index.indexStart(example, indexOperation, operator);
        int indexEnd = index.indexEnd(example, indexOperation, operator);
        if (indexOperation != -1) {//перевод и счет
            try {
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


    public List<Character> checkOperator(String example) {//приоритетный оператор
        List<Character> operations1 = Arrays.asList('^');
        if (operatorPriority(example, operations1)) {
            return operations1;
        }
        List<Character> operations2 = Arrays.asList('*', '/');
        if (operatorPriority(example, operations2)) {
            return operations2;
        }
        List<Character> operations3 = Arrays.asList('+', '-');
        if (operatorPriority(example, operations3)) {
            return operations3;
        }
        System.exit(0);
        return null;
    }

    public boolean operatorPriority(String example, List<Character> operations) {//наличие приоритетного оператора
        for (int i = 0; i < operations.size(); i++) {
            int indexOperation = example.indexOf(operations.get(i));
            if (indexOperation != -1) {
                return true;
            }
        }
        return false;
    }
}