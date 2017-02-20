import java.util.ArrayList;
import java.util.Scanner;

public class StringCalculator {
    public static void main(String[] args) {
        String equation;
        double number1;
        double number2;
        double answer;
        Scanner operation = new Scanner(System.in);
        System.out.println("Enter in your equation");
        equation = operation.nextLine();
        String[] expression = equation.split("");
        ArrayList operators = new ArrayList();
        ArrayList numbers = new ArrayList();
        for (int i = 0; i < expression.length; i++) {
            if (expression[i].equals("*") || expression[i].equals("/") || expression[i].equals("+") || expression[i].equals("-")) {
                operators.add(expression[i]);
            }
            else{
                numbers.add(Double.parseDouble(expression[i]));
            }
        }
        System.out.println(operators);
        System.out.println(numbers);
        try {
            for (int i = 0; i < operators.size(); i++) {
                if (operators.get(i).equals("*") || operators.get(i).equals("/")) {
                    number1 = (double) numbers.get(i);
                    number2 = (double) numbers.get(i + 1);
                    System.out.println("NUummbers assigned");
                    if (operators.get(i).equals("*")) {
                        answer = number1 * number2;
                    } else {
                        answer = number1 / number2;
                    }
                    System.out.println("Removing numbers");
                    operators.remove(i);
                    numbers.remove(i+1);
                    numbers.remove(i);
                    numbers.add(i, answer);
                    System.out.println("multiplication");
                    System.out.println("division");
                    i = i-1;
                }
            }
            for (int i = 0; i < operators.size(); i++){
                if (operators.get(i).equals("+") || operators.get(i).equals("-")) {
                    number1 = (double) numbers.get(i);
                    number2 = (double) numbers.get(i + 1);
                    if (operators.get(i).equals("+")) {
                        answer = number1 + number2;
                    } else {
                        answer = number1 - number2;
                    }
                    operators.remove(i);
                    numbers.remove(i+1);
                    numbers.remove(i);
                    numbers.add(i, answer);
                    System.out.println("Addition/Subtraction");
                    i=i-1;
                }
            }
        }catch(IndexOutOfBoundsException e){
            System.out.println("Problem in catch");
            System.out.println(numbers);

        }
        System.out.println(numbers);
    }
}