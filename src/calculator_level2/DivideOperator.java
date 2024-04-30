package calculator_level2;

// 나누기 연산 클래스
public class DivideOperator {
    public double divide(double firstNumber, double secondNumber) throws ArithmeticException {
        if (secondNumber == 0) {
            throw new ArithmeticException("나누기에서는 0으로 나눌 수 없습니다.");
        }
        return firstNumber / secondNumber;
    }
}
