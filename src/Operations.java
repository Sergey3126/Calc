
import java.util.*;

public class Operations {
    public String arithmetic(String example) {
        CalculatorWithMathCopy calc = new CalculatorWithMathCopy();
        StringBuilder sb = new StringBuilder(example);
        String result = "";
        double num1 = 0;
        double num2 = 0;
        List<Character> operation = Arrays.asList('*', '/', '+', '-');
        List<Character> operations = checkOperator(example);
        int indexOperation = indexOperation(example, operations);
        int indexStart = indexStart(example, indexOperation, operations, operation);
        int indexEnd = indexEnd(example, indexOperation, operations, operation);
        if (indexOperation != -1) {//перевод и счет
            try {
                String num = example.substring(indexStart, indexOperation);
                num1 = Double.parseDouble(num);
                num = example.substring(indexOperation + 1, indexEnd + 1);
                num2 = Double.parseDouble(num);
            } catch (Exception e) {
         System.err.println("Ошибка ввода");
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

    public int indexStart(String example, int indexOperation, List<Character> operations, List<Character> operation) {
        int indexStart = -1;
        boolean condition = true;
        for (int i = indexOperation - 1; i >= 0 && condition; i--) {//начало примера
            for (int j = 0; j < operation.size(); j++) {
                if (i == 0) {//если начало
                    indexStart = 0;
                    condition = false;
                    break;
                }
                if (example.charAt(i) == operation.get(j)) {
                    indexStart = i + 1;
                    condition = false;
                    break;
                }
            }
        }
        return indexStart;
    }

    public int indexEnd(String example, int indexOperation, List<Character> operations, List<Character> operation) {
        int indexEnd = -1;
        boolean condition = true;
        for (int i = indexOperation + 1; i < example.length() && condition; i++) {//конец примера
            for (int j = 0; j < operation.size(); j++) {
                if (i == example.length() - 1) {//если  конец
                    indexEnd = example.length() - 1;
                    condition = false;
                    break;
                } else if (example.charAt(i) == operation.get(j)) {
                    indexEnd = i - 1;
                    condition = false;
                    break;
                }
            }
        }
        return indexEnd;
    }

    public int indexOperation(String example, List<Character> operations) {
        List<Integer> indexOperations = new ArrayList<>();
        for (int i = 0; i < operations.size(); i++) {
            int indexOperation = 0;
            while (true) {
                indexOperation = example.indexOf(operations.get(i), indexOperation + 1);
                if (indexOperation != -1) {
                    indexOperations.add(indexOperation);
                } else {
                    break;
                }
            }
        }
        Collections.sort(indexOperations);
        return indexOperations.get(0);
    }

    public List<Character> checkOperator(String example) {
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

    public boolean operatorPriority(String example, List<Character> operations) {
        for (int i = 0; i < operations.size(); i++) {
            int indexOperation = example.indexOf(operations.get(i));
            if (indexOperation != -1) {
                return true;
            }
        }
        return false;
    }
}