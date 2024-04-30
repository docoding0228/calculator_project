package calculator_level2;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private List<Integer> results; // 계산 결과를 저장할 리스트

    public Calculator() {
        this.results = new ArrayList<>();
    }

    public int calculate(int firstNumber, int secondNumber, char operator) throws IllegalArgumentException {
        // IllegalArgumentException : 주로 메서드나 생성자에서 전달된 인자가 잘못되거나 유효하지 않을 때 사용됩니다.
        // 예를 들어, 음수 값이 허용되지 않는 메서드에 음수 값이 전달되거나, 잘못된 형식의 문자열이 전달되는 경우
        int result;
        switch (operator) {
            case '+':
                result = firstNumber + secondNumber;
                break;
            case '-':
                result = firstNumber - secondNumber;
                break;
            case '*':
                result = firstNumber * secondNumber;
                break;
            case '/':
                if (secondNumber == 0) {
                    throw new IllegalArgumentException("분모는 0일 수 없습니다.");
                }
                result = firstNumber / secondNumber;
                break;
            default:
                throw new IllegalArgumentException("유효하지 않은 연산자입니다.");
        }
        results.add(result); // 결과 저장
        return result; // 계산 결과 반환
    }

    public List<Integer> getResults() {
        return new ArrayList<>(results); // 결과 목록 반환
    }

    public boolean removeOldestResult() {
        if (!results.isEmpty()) {
            results.remove(0); // 가장 오래된 결과 제거
            return true; // 성공적으로 제거됨
        }
        return false; // 제거할 결과가 없음
    }
}
