package operatorsPriority;

import api.IOperatorsPriority;

import java.util.Arrays;
import java.util.List;

public class OperatorPriority1 implements IOperatorsPriority {
    private final List<Character> listOperators = Arrays.asList('^');


    @Override
    public List<Character> getListOperators() {
        return this.listOperators;
    }

    @Override
    public String getResultCalculations(String expression, int indexOperation, double num1, double num2) {
        switch (expression.charAt(indexOperation)) {
            case '^':
                return String.valueOf(pow(num1, (int) num2));
        }
        return expression;
    }

    /**
     * степень
     *
     * @param pow1
     * @param pow2
     * @return
     */
    private double pow(double pow1, int pow2) {
        double result = Math.pow(pow1, pow2);
        return result;
    }


}
