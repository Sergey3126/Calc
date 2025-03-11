
import operatorsPriority.AllOperators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;


/**
 * обработка скобок
 */
public class Limiters {
    private AllOperators allOperators = new AllOperators();


    public List<Integer> brackets(String expression, int num) {
        List<Integer> index = new ArrayList();
        int openIndex = expression.lastIndexOf('(', num);
        int closeIndex = expression.indexOf(')', openIndex);
        index.add(openIndex);
        index.add(closeIndex);
        return index;
    }

    public List<Integer> module(String expression) {
        List<Integer> index = new ArrayList();
        String operators = "+-*/^";
        int openIndex = expression.indexOf('|');
        int closeIndex = expression.indexOf('|', openIndex + 1);
        boolean b = true;

        while (b) {
            b = false;
            char c = expression.charAt(closeIndex - 1);
            if (openIndex == closeIndex - 1) {
                openIndex = closeIndex;
                closeIndex = expression.indexOf('|', closeIndex + 1);
                b = true;
            }

            if (operators.contains(String.valueOf(c))) {
                openIndex = closeIndex;
                closeIndex = expression.indexOf('|', closeIndex + 1);
                b = true;
            }
        }

        index.add(openIndex);
        index.add(closeIndex);
        return index;
    }

    public String replacement(String expression, int openIndex, int closeIndex) {
        Check check = new Check();
        Pattern pattern1 = Pattern.compile("[+\\-*^()|/]");
        Pattern pattern2 = Pattern.compile("[+*^()|/]");
        Arithmetic arithmetic = new Arithmetic();
        Operator operator = new Operator();
        List<Character> minus = Arrays.asList('-');
        CalculatorWithMathCopy calc = new CalculatorWithMathCopy();

        String newExample;
        for (newExample = expression.substring(openIndex + 1, closeIndex); check.result(newExample, pattern1) && (check.result(newExample, pattern2) || operator.checkOperatorPriority(newExample, minus)); newExample = arithmetic.arithmetic(newExample)) {
        }

        if (expression.charAt(openIndex) == '|') {
            newExample = String.valueOf(calc.module(Double.parseDouble(newExample)));
        }

        StringBuilder sb = new StringBuilder(expression);
        sb.replace(openIndex, closeIndex + 1, newExample);
        expression = sb.toString();
        return expression;
    }

    public String limiters(String expression) {
        List<Integer> moduleIndex = new ArrayList();
        List<Integer> bracketsIndex = new ArrayList();
        if (expression.indexOf('(') != -1 && expression.indexOf('|') != -1) {
            moduleIndex = module(expression);
            bracketsIndex = brackets(expression, moduleIndex.get(1));
            int openIndex;
            int closeIndex;
            if (moduleIndex.get(0) < bracketsIndex.get(0) && moduleIndex.get(1) > bracketsIndex.get(1)) {
                openIndex = bracketsIndex.get(0);
                closeIndex = bracketsIndex.get(1);
            } else {
                openIndex = moduleIndex.get(0);
                closeIndex = moduleIndex.get(1);
            }

            return this.replacement(expression, openIndex, closeIndex);
        } else if (expression.indexOf('|') != -1) {
            moduleIndex = module(expression);
            return replacement(expression, moduleIndex.get(0), moduleIndex.get(1));
        } else if (expression.indexOf('(') != -1) {
           bracketsIndex = brackets(expression, 0);
            return replacement(expression, bracketsIndex.get(0), bracketsIndex.get(1));
        } else {
            return expression;
        }
    }
}

