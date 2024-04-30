package calculator_level2;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private List<Integer> results; // 연산 결과를 저장하는 리스트

    public Calculator() {
        this.results = new ArrayList<>(); // 리스트 초기화
    }

    public int calculate(int firstNumber, int secondNumber, char operator) {
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

        results.add(result); // 연산 결과를 리스트에 추가
        return result;
    }

    // 저장된 연산 결과를 조회하는 메서드
    public List<Integer> getAllResults() {
        return new ArrayList<>(results); // 현재까지 저장된 결과를 반환
    }

    public boolean removeOldestResult() {
        if (!results.isEmpty()) {
            results.remove(0); // 가장 오래된 결과 삭제
            return true;
        }
        return false; // 삭제할 결과가 없는 경우
    }
}
