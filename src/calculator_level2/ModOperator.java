package calculator_level2;

public class ModOperator {
    public double mod(double firstNumber, double secondNumber) throws ArithmeticException {
        if (secondNumber == 0) {
            throw new ArithmeticException("나머지 연산에서는 0으로 나눌 수 없습니다.");
        }
        return firstNumber % secondNumber;
    }

}
