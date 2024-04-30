package calculator_level2;

// 곱하기 연산 클래스
public class MultiplyOperator implements Operator {  // Operator 인터페이스 구현
    @Override
    public double operate(double firstNumber, double secondNumber) {
        return firstNumber * secondNumber;  // 곱하기 연산
    }
}
