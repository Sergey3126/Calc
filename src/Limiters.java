import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;


/**
 * обработка скобок
 */
public class Limiters {


    public String brackets(String example) {
        int openIndex = example.lastIndexOf('(');
        int closeIndex = example.indexOf(')', openIndex);
        return limit(example,openIndex,closeIndex);
    }

    public String module(String example) {
        String operators = "+-*/^";
        int openIndex = example.indexOf('|');
        int closeIndex = example.indexOf('|', openIndex + 1);
        char c ;
        boolean b=true;
        while (b) {
            b=false;
            c = example.charAt(closeIndex-1);
            if (openIndex == closeIndex - 1) {
                openIndex = closeIndex;
                closeIndex = example.indexOf('|', openIndex + 1);
                b=true;
            }
            if (operators.contains(String.valueOf(c))) {
                openIndex = closeIndex;
                closeIndex = example.indexOf('|', openIndex + 1);
                b=true;
            }
        }
        return limit(example,openIndex,closeIndex);
    }
    public String limit(String example,int openIndex,int closeIndex){
        Check check = new Check();
        Pattern pattern1 = Pattern.compile("[+\\-*^()|/]");
        Pattern pattern2 = Pattern.compile("[+*^()|/]");
        Arithmetic arithmetic = new Arithmetic();
        Operator operator = new Operator();
        List<Character> minus = Arrays.asList('-');
        CalculatorWithMathCopy calc = new CalculatorWithMathCopy();
      String newExample = example.substring(openIndex + 1, closeIndex);
        while (check.result(newExample, pattern1)) {
            if (!check.result(newExample, pattern2) && !operator.checkOperatorPriority(newExample, minus)) { //если отрицательно число
                break;
            }
            newExample = arithmetic.arithmetic(newExample);
        }

        newExample = String.valueOf(calc.module(Double.parseDouble(newExample)));
        StringBuilder sb = new StringBuilder(example);
        sb.replace(openIndex, closeIndex + 1, newExample);
        example = sb.toString();
        return example;
    }
}

