import api.IOperatorsPriority;
import operatorsPriority.AllOperators;

import java.util.List;


public class Arithmetic {

    private AllOperators allOperators = new AllOperators();

    private List<IOperatorsPriority> operatorsPriorityList = allOperators.getOperatorsPriorityList();


    /**
     * получение чисел и счет
     *
     * @param expression
     * @return
     */
    public String arithmetic(String expression) {
        Operator operator = new Operator();
        StringBuilder sb = new StringBuilder(expression);
        IndexSearcher indexSearcher = new IndexSearcher();
        String result = "";
        double num1 = 0;
        double num2 = 0;
        //сделал отдельный класс который отдает или лист либо строку со всеми операторами
        List<Character> operators = allOperators.getAllOperatorsList();//доступные операторы
        List<Character> operations = operator.checkOperator(expression);//первые операторы
        int indexOperation = indexSearcher.indexOperation(expression, operations);
        int indexStart = indexSearcher.indexStart(expression, indexOperation, operators);
        int indexEnd = indexSearcher.indexEnd(expression, indexOperation, operators);
        if (indexOperation != -1) {
            try {//перевод числа
                String num = expression.substring(indexStart, indexOperation);//получение чисел
                num1 = Double.parseDouble(num);
                num = expression.substring(indexOperation + 1, indexEnd + 1);
                num2 = Double.parseDouble(num);
            } catch (Exception e) {
                System.err.println("Ошибка счета");
                System.exit(0);
            }
            //считает в том порядке что у тебя были свитчи. теперь они распиханы по классам согласно приоритетности
            for (int i = 0; i < operatorsPriorityList.size(); i++) {
                String result1 = operatorsPriorityList.get(i).getResultCalculations(expression, indexOperation, num1, num2);
                if (!expression.equals(result1)){
                    result = result1;
                    break;
                }
            }
            sb.replace(indexStart, indexEnd + 1, result);
            String str = sb.toString();
            return str;
        } else {
            return expression;
        }

    }
}
