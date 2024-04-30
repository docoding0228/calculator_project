package calculator_level2;

// 나누기 연산 클래스
public class DivideOperator implements Operator {  // Operator 인터페이스 구현
    @Override
    public double operate(double firstNumber, double secondNumber) throws ArithmeticException {
        if (secondNumber == 0) {
            throw new ArithmeticException("나누기에서는 0으로 나눌 수 없습니다.");  // 0으로 나누기 예외
        }
        return firstNumber / secondNumber;  // 나누기 연산
    }
}
