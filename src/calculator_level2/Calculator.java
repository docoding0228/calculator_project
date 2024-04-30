package calculator_level2;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    // 연산 결과를 저장하는 컬렉션 필드. private으로 설정하여 외부 접근을 제한
    private List<Integer> results;

    // 생성자
    public Calculator() {
        this.results = new ArrayList<>(); // 초기화
    }

    // 연산 메서드
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
                // IllegalArgumentException : 주로 메서드나 생성자에서 전달된 인자가 잘못되거나 유효하지 않을 때 사용된다.
                // 예를 들어, 음수 값이 허용되지 않는 메서드에 음수 값이 전달되거나, 잘못된 형식의 문자열이 전달되는 경우
        }

        results.add(result); // 연산 결과를 컬렉션에 추가
        return result; // 계산된 결과 반환
    }

    // 외부에서 직접 수정할 수 없도록 새 리스트 반환, 연산 결과를 반환하는 getter 메서드
    public List<Integer> getResults() {
        return new ArrayList<>(results); // 외부에서 리스트를 수정할 수 없도록 새로운 리스트 반환
    }

    // 외부의 리스트를 복사하여 내부 필드에 설정 , 연산 결과를 설정하는 setter 매서드
    public void setResults(List<Integer> newResults) {
        this.results = new ArrayList<>(newResults);
    }

    // 가장 오래된 결과를 삭제하는 메서드
    public boolean removeOldestResult() {
        if (!results.isEmpty()) {
            results.remove(0);
            return true;
        }
        return false;
    }
}
