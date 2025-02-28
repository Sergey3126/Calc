
public class CalculatorWithMathCopyMain {
    public static void main(String[] args) {
        Operations operations = new Operations();
        Check check = new Check();
//        String example;
//        while (true){
//            System.out.println("Введите пример");
//            System.out.println("Для помощи введите-Помощь");
//         example = scanner.next();
//        if (example.toLowerCase().equals("помощь")) {
//            System.out.println("Запрещены буквы. Список доступных операторов: 1.+(сложение) 2.-(вычитание) 3.*(умножить) 4./(деление) 5.^(степень)");
//        }else {
//            break;
//        }}
        String example = "2*(-4)";
        example = example.replaceAll("[\\n\\s]", "");//убирает пробел и обзац
check.checkExpression(example);
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