package operatorsPriority;

import api.IOperatorsPriority;

import java.util.Arrays;
import java.util.List;

public class OperatorPriority2 implements IOperatorsPriority {
   private final List<Character> listOperators= Arrays.asList('*', '/');


    @Override
    public List<Character> getListOperators() {
        return this.listOperators;
    }

    @Override
    public String getResultCalculations(String expression, int indexOperation, double num1, double num2) {
        switch (expression.charAt(indexOperation)) {
            case '*':
                return String.valueOf(multiplication(num1, num2));
            case '/':
                return String.valueOf(division(num1, num2));
        }
        return expression;
    }

    /**
     * деление
     *
     * @param division1
     * @param division2
     * @return
     */
    private double division(double division1, double division2) {
        if (division2 == 0) {
            System.out.println("Деление на 0");
            System.exit(0);
        }
        double result = division1 / division2;
        return result;
    }

    /**
     * умножение
     *
     * @param multiplication1
     * @param multiplication2
     * @return
     */
    private double multiplication(double multiplication1, double multiplication2) {
        double result = multiplication1 * multiplication2;
        return result;
    }



}
