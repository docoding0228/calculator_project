package calculator_level2;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    // 2-7
    private static final double PI = 3.141592; // 원의 넓이 계산을 위한 상수
    private List<Integer> results; // 사칙연산 결과를 저장하는 컬렉션

    // 2-7
    private List<Double> circleAreas; // 원의 넓이 결과를 저장하는 컬렉션

    // 생성자 - 컬렉션 필드 초기화
    public Calculator() {
        this.results = new ArrayList<>(); // 사칙연산 결과용 컬렉션
        // 2-7
        this.circleAreas = new ArrayList<>(); // 원의 넓이 결과용 컬렉션
    }
    // 2-2
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

        results.add(result); // 연산 결과를 컬렉션에 추가
        return result; // 결과 반환
    }
    // 2-7
    // 원의 넓이 계산 및 저장
    public double calculateCircleArea(double radius) {
        double area = PI * radius * radius; // 원의 넓이 계산
        circleAreas.add(area); // 결과 저장
        return area; // 계산 결과 반환
    }

    // 2-5
    // Calculator 클래스에 저장된 연산 결과들을 조회하는 기능을 가진 메서드를 구현한 후 App 클래스의 main 메서드에 조회 메서드가 활용될 수 있도록 수정
    public List<Integer> getAllResults() {
        return new ArrayList<>(results); // 리스트 복사본 반환 (외부에서 직접 수정하지 못하도록)
    }
    // 2-7
    // 원의 넓이 결과 Getter
    public List<Double> getAllCircleAreas() {
        return new ArrayList<>(circleAreas); // 리스트 복사본 반환
    }
    // 2-7
    // 원의 넓이 결과 Setter
    public void setCircleAreas(List<Double> newCircleAreas) {
        this.circleAreas = new ArrayList<>(newCircleAreas); // 새로운 결과 리스트로 초기화
    }
    // 2-4
    public boolean removeOldestResult() {
        if (!results.isEmpty()) {
            results.remove(0); // 가장 오래된 사칙연산 결과 삭제
            return true;
        }
        return false; // 삭제할 결과가 없는 경우
    }
}
