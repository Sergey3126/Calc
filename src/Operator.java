
import api.IOperatorsPriority;
import operatorsPriority.AllOperators;


import java.util.*;

public class Operator {
    private AllOperators allOperators = new AllOperators();
    private List<IOperatorsPriority> operatorsPriorityList = allOperators.getOperatorsPriorityList();


    /**
     * оператор который проверяем
     * @param example
     * @return
     */
    public List<Character> checkOperator(String example) {//приоритетный оператор
        //вот тут заменил на фор

        for (int i = 0; i < operatorsPriorityList.size(); i++) {
            List<Character> operations = operatorsPriorityList.get(i).getListOperators();

            if (checkOperatorPriority(example, operations)) {
                return operations;
            }
        }
        System.exit(0);
        return null;
    }

    /**
     * проверка есть ли оператор
     * @param example
     * @param operations
     * @return
     */
    public boolean checkOperatorPriority(String example, List<Character> operations) {//наличие приоритетного оператора
        for (int i = 0; i < operations.size(); i++) {
            int indexOperation = example.indexOf(operations.get(i), 1);
            if (indexOperation != -1) {
                return true;
            }
        }
        return false;
    }
}