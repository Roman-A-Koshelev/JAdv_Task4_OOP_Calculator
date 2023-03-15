package calc;

import calc.operations.*;

import java.util.Scanner;

/**
 * Калькулятор
 */
public class Calculator {

    /**
     * Метод выполняет операции калькулятора (сложение, вычитание, деление или
     * умножение) над дробными числами.
     * @param a Первое дробное число
     * @param b Второе дробное число
     * @param strOp Операция выполняемая над дробными числами.
     */
    private void evaluate(double a, double b, String strOp) {
        if (1 != strOp.length()) {
            System.err.println("Операция \"" + strOp + "\" не поддерживается!");
            return;
        }

        double res;
        Operation op;
        switch(strOp.charAt(0)) {
            case '+':
                op = new Plus();
                res = op.evaluate(a, b);
                break;

            case '-':
                op = new Minus();
                res = op.evaluate(a, b);
                break;

            case '*':
                op = new Mult();
                res = op.evaluate(a, b);
                break;

            case '/':
                op = new Div();
                res = op.evaluate(a, b);
                if (Double.isNaN(res)) {
                    System.err.println("Делитель не должен быть равен нулю!");
                    return;
                }
                break;

            default:
                System.err.println("Операция \"" + strOp + "\" не поддерживается!");
                return ;
        }

        System.out.printf("Результат операции = %.4f", res);
    }

    public void evaluate() {
        Scanner in = new Scanner(System.in);
        System.out.println("Необходимо ввести два дробных числа и знак операции (‘+’, ‘-’, ‘*’ или ‘/’).");

        System.out.print("Введите первое число:   ");
        double a = in.nextDouble();

        System.out.print("Введите второе число:   ");
        double b = in.nextDouble();

        System.out.print("Введите знак операции:  ");
        String op = in.next();

        evaluate(a, b, op);
    }
}
