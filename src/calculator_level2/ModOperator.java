package calculator_level2;

// 나머지 연산 클래스
public class ModOperator implements Operator {  // Operator 인터페이스 구현
    @Override
    public double operate(double firstNumber, double secondNumber) throws ArithmeticException {
        if (secondNumber == 0) {
            throw new ArithmeticException("나머지 연산에서는 0으로 나눌 수 없습니다.");  // 0으로 나눌 수 없음
        }
        return firstNumber % secondNumber;  // 나머지 연산
    }
}
