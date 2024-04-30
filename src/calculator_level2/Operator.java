package calculator_level2;

// 연산을 위한 인터페이스
public interface Operator {
    double operate(double firstNumber, double secondNumber) throws Exception;  // 연산을 수행하는 메서드
}