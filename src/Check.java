
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Check {
    public boolean result(String example) {
        Pattern pattern = Pattern.compile("[+\\-*^()|/]");
        Matcher matcher = pattern.matcher(example);
        return matcher.find();//наличие оператора
    }

    public String example() {
        Scanner scanner = new Scanner(System.in);

        String example = "10+2+1*10";
//String example;
//        while (true){
//            System.out.println("Введите пример");
//            System.out.println("Для помощи введите-Помощь");
//         example = scanner.next();
//        if (example.toLowerCase().equals("помощь")) {
//            System.out.println("Запрещены буквы. Список доступных операторов: 1.+(сложение) 2.-(вычитание) 3.*(умножить) 4./(деление) 5.^(степень)");
//        }else {
//            break;
//        }}
        return example;
    }
}
