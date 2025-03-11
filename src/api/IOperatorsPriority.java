package api;

import java.util.List;

public interface IOperatorsPriority {
    List<Character> getListOperators();
    String getResultCalculations (String expression, int indexOperation, double num1, double num2);
}
