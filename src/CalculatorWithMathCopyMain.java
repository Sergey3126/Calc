
public class CalculatorWithMathCopyMain {
    public static void main(String[] args) {
        Operations operations = new Operations();
        Check check = new Check();
        String example = check.example();
        example = example.replaceAll("[\\n\\s]", "");//убирает пробел и обзац
        System.out.println(example);
        while (check.result(example)) {
            example = operations.arithmetic(example);
            System.out.println(example);
        }
    }
}
/*
1.Ищу оператор с высшим приоритетом
2.Ищу числа по бокам
2.1 Левым ограничителем является некий оператор(или не цифра)
2.2 Правым ограничителем является некий оператор(или не цифра)
3 Счита выражение
4 Результат заменяю выражением
 */