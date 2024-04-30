package calculator_level2;

// 원 관련 계산을 위한 클래스, Calculator를 상속받음
public class CircleCalculator extends Calculator {
    public double calculateCircleArea(double radius) {
        if (radius < 0) {
            throw new IllegalArgumentException("반지름은 음수일 수 없습니다.");
        }
        double area = Math.PI * radius * radius;  // 원의 넓이 계산
        results.add(area);  // 결과를 저장
        return area;
    }
}
