import calc.Calculator;

import java.util.Scanner;

public class Main {
    static void calculate(Calculator calc) {
        Scanner in = new Scanner(System.in);
        System.out.println("Необходимо ввести два дробных числа и знак операции (‘+’, ‘-’, ‘*’ или ‘/’).");

        System.out.print("Введите первое число:   ");
        double a = in.nextDouble();

        System.out.print("Введите второе число:   ");
        double b = in.nextDouble();

        System.out.print("Введите знак операции:  ");
        String op = in.next();

        int errorCode = calc.evaluate(a, b, op);
        if (Calculator.ERROR_OK == errorCode) {
            System.out.printf("Результат операции = %.4f", calc.getValue());
        }
        else {
            System.err.println("Произошла ОШИБКА: " + calc.getErrorText(errorCode));
        }
        in.close();
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        calculate(calc);
    }
}
