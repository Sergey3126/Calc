package operatorsPriority;

import api.IOperatorsPriority;

import java.util.Arrays;
import java.util.List;

public class OperatorPriority3 implements IOperatorsPriority {
   private final List<Character> listOperators= Arrays.asList('+', '-');


    @Override
    public List<Character> getListOperators() {
        return this.listOperators;
    }

    @Override
    public String getResultCalculations(String expression, int indexOperation, double num1, double num2) {
        switch (expression.charAt(indexOperation)) {
            case '+':
                return  String.valueOf(sum(num1, num2));
            case '-':
                return  String.valueOf(minus(num1, num2));
        }
        return expression;
    }

    /**
     * вычитание
     *
     * @param minus1
     * @param minus2
     * @return
     */
    private double minus(double minus1, double minus2) {
        double result = minus1 - minus2;
        return result;
    }

    /**
     * сложение
     *
     * @param plus1
     * @param plus2
     * @return
     */
    private double sum(double plus1, double plus2) {
        double plus = plus1 + plus2;
        return plus;
    }


}
