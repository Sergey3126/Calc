
import java.util.*;

public class Operator {


    public List<Character> checkOperator(String example) {//приоритетный оператор
        List<Character> operations1 = Arrays.asList('^');
        if (checkOperatorPriority(example, operations1)) {
            return operations1;
        }
        List<Character> operations2 = Arrays.asList('*', '/');
        if (checkOperatorPriority(example, operations2)) {
            return operations2;
        }
        List<Character> operations3 = Arrays.asList('+', '-');
        if (checkOperatorPriority(example, operations3)) {
            return operations3;
        }
        System.exit(0);
        return null;
    }

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