import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/*
получение индексов начала и конца выражения и индекс оператора
 */
public class Index {
    /**
     * индекс начала
     * @param example
     * @param indexOperation
     * @param operation
     * @return
     */
    public int indexStart(String example, int indexOperation, List<Character> operation) {
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
                    if (example.charAt(i) == '-') {
                        if (!Character.isDigit(example.charAt(i - 1))) {//если отрицательно число
                            indexStart = i;
                            condition = false;
                            break;
                        }
                    }
                    indexStart = i + 1;
                    condition = false;
                    break;
                }

            }
        }
        return indexStart;
    }

    /**
     * индекс конца
     * @param example
     * @param indexOperation
     * @param operation
     * @return
     */
    public int indexEnd(String example, int indexOperation, List<Character> operation) {
        int indexEnd = -1;
        boolean condition = true;
        if (example.charAt(indexOperation + 1) == '-') {
            indexOperation = indexOperation + 1;
        }
        for (int i = indexOperation + 1; i < example.length() && condition; i++) {//конец примера
            for (int j = 0; j < operation.size(); j++) {
                if (i == example.length() - 1) {//если  конец
                    indexEnd = example.length() - 1;
                    condition = false;
                    break;
                } else if (example.charAt(i) == operation.get(j)) {//если отрицательно число
                    indexEnd = i - 1;
                    condition = false;
                    break;
                }
            }
        }
        return indexEnd;
    }

    /**
     * индекс оператора
     * @param example
     * @param operations
     * @return
     */
    public int indexOperation(String example, List<Character> operations) {
        List<Integer> indexOperations = new ArrayList<>();//индекс  оператора
        int indexOperation = 0;
        for (int i = 0; i < operations.size(); i++) {
            indexOperation = 0;
            while (true) {
                indexOperation = example.indexOf(operations.get(i), indexOperation + 1);
                if (indexOperation != -1) {
                    indexOperations.add(indexOperation);
                    if (example.charAt(indexOperation) == '-') {
                        if (!Character.isDigit(example.charAt(indexOperation - 1))) {//если отрицательно число
                            indexOperations.remove(indexOperations.size() - 1);
                        }
                    }

                } else {
                    break;
                }
            }
        }
        Collections.sort(indexOperations);
        return indexOperations.get(0);
    }


}
