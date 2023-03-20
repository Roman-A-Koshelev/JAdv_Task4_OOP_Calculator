package calc;

import calc.operations.*;

/**
 * Калькулятор
 */
public class Calculator {
    public static final int ERROR_OK = 0;
    public static final int ERROR_OP_NOT_SUP = -1;
    public static final int ERROR_ZERO_DIV = -2;

    private double val = 0.0;
    /**
     * Метод выполняет операции калькулятора (сложение, вычитание, деление или
     * умножение) над дробными числами.
     * @param a Первое дробное число
     * @param b Второе дробное число
     * @param strOp Операция выполняемая над дробными числами.
     * @return Код ошибки. Код == 0 - OK, Код < 0 - Ошибка.
     */
    public int evaluate(double a, double b, String strOp) {
        if (1 != strOp.length()) {
            return ERROR_OP_NOT_SUP;
        }

        Operation op;
        switch(strOp.charAt(0)) {
            case '+':
                op = new Plus();
                val = op.evaluate(a, b);
                return ERROR_OK;

            case '-':
                op = new Minus();
                val = op.evaluate(a, b);
                return ERROR_OK;

            case '*':
                op = new Mult();
                val = op.evaluate(a, b);
                return ERROR_OK;

            case '/':
                op = new Div();
                val = op.evaluate(a, b);
                if (Double.isNaN(val)) {
                    return ERROR_ZERO_DIV;
                }
                return ERROR_OK;
        }

        return ERROR_OP_NOT_SUP;
    }

    public String getErrorText(int errorCode) {
        switch(errorCode) {
            case ERROR_OK:         return "Всё хорошо!";
            case ERROR_OP_NOT_SUP: return "Операция не поддерживается!";
            case ERROR_ZERO_DIV:   return "Делитель не должен быть равен нулю!";
        }

        return "Описание ошибки с кодом \"" + errorCode + "\" отсутсвует.";
    }

    public double getValue() {
        return val;
    }

}
