package operatorsPriority;

import api.IOperatorsPriority;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllOperators {
    private IOperatorsPriority operatorPriority3 = new OperatorPriority3();
    private IOperatorsPriority operatorPriority2 = new OperatorPriority2();
    private IOperatorsPriority operatorPriority1 = new OperatorPriority1();

    private List<Character> allOperatorsList = new ArrayList<>();
    private String allOperatorsString = "";
    private List<IOperatorsPriority> operatorsPriorityList = Arrays.asList(operatorPriority1,operatorPriority2, operatorPriority3);



    public AllOperators() {
        allOperatorsList.addAll(operatorPriority3.getListOperators());
        allOperatorsList.addAll(operatorPriority2.getListOperators());
        allOperatorsList.addAll(operatorPriority1.getListOperators());

        for (int i = 0; i < allOperatorsList.size(); i++) {
            allOperatorsString += allOperatorsList.get(i);
        }

    }

    public List<Character> getAllOperatorsList() {
        return allOperatorsList;
    }

    public String getAllOperatorsString() {
        return allOperatorsString;
    }

    public List<IOperatorsPriority> getOperatorsPriorityList() {
        return operatorsPriorityList;
    }
}


