import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorMain {
    public static void main(String[] args) {
        System.out.println("Enter numbers for calculate: ");
        Scanner sc = new Scanner(System.in);
        String scannerStr = sc.next();
        sc.close();
        if (scannerStr.length() != 0 && !isInputValid(scannerStr)){
            Expression exp = new ExpressionBuilder(scannerStr).build();
            double sumResult = exp.evaluate();
            System.out.println("Result: " + sumResult);
        } else {
            System.out.println("Wrong input");
        }
    }

    public static boolean isInputValid(String str){
        Pattern pattern = Pattern.compile("(^[+-/*]|[a-zA-Zа-яА-Я]+|[+-/*]{2,}|[+-/*]$)");
        Matcher matcher = pattern.matcher(str);
        return matcher.find();
    }
}
