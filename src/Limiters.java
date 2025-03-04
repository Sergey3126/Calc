import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Limiters {
    public String brackets(String example){
        Arithmetic arithmetic = new Arithmetic();
        Check check = new Check();
        Operator operator = new Operator();
        Pattern pattern1 = Pattern.compile("[+\\-*^()|/]");
        Pattern pattern2 = Pattern.compile("[+*^()|/]");
        List<Character> minus = Arrays.asList('-');
        int openIndex = example.lastIndexOf('(');
        int closeIndex = example.indexOf(')',openIndex);
        String newExample = example.substring(openIndex + 1, closeIndex);
        while (check.result(newExample, pattern1)) {
            if (!check.result(newExample,pattern2)){//если остался только минус
                if (!operator.checkOperatorPriority(newExample,minus)) {//если отрицательно число
                    break;
                }
            }
            newExample = arithmetic.arithmetic(newExample);
        }
        StringBuilder sb = new StringBuilder(example);
        sb.replace(openIndex, closeIndex + 1, newExample);
        example = sb.toString();
        return example;
    }
}
