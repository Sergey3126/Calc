import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Index {
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
                    indexStart = i + 1;
                    condition = false;
                    break;
                }

            }
        }
        return indexStart;
    }

    public int indexEnd(String example, int indexOperation, List<Character> operation) {
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
        List<Integer> indexOperations = new ArrayList<>();//индекс  оператора
        int indexOperation = 0;
        for (int i = 0; i < operations.size(); i++) {
            indexOperation = 0;
            while (true) {
                indexOperation = example.indexOf(operations.get(i), indexOperation + 1);

                if (indexOperation != -1) {
                    indexOperations.add(indexOperation);
                } else  {
                    break;
                }
            }
        }
        Collections.sort(indexOperations);
        return indexOperations.get(0);
    }


}
