package calculator_level2;
import java.util.ArrayList;
import java.util.LinkedList;

import java.util.List;

// 커스텀 예외 클래스 생성
class CalculatorException extends Exception {
    public CalculatorException(String message) {
        super(message);
        // 예외 메시지를 전달
    }
}

public class Calculator {
    // 연산 결과를 저장할 컬렉션 타입 필드
    List<Integer> results = new ArrayList<>();
    // 사칙연산을 수행하는 메서드
    public double calculate(int firstNumber, int secondNumber, char operator) throws CalculatorException {
        int result = 0; // 연산 결과를 저장할 변수

        switch (operator) {
            case '+':
                result = firstNumber + secondNumber; // 덧셈
                break;
            case '-':
                result = firstNumber - secondNumber; // 뺄셈
                break;
            case '*':
                result = firstNumber * secondNumber; // 곱셈
                break;
            case '/':
                if (secondNumber == 0) {
                    throw new CalculatorException("분모에 0이 들어올 수 없습니다.");
                }
                result = firstNumber / secondNumber;; // 나눗셈
                break;
            default:
                throw new CalculatorException("유효하지 않은 연산자입니다.");
        }
        return result; // 계산 결과 반환
    }
}
