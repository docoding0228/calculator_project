package calculator_level2;

import java.util.Scanner;

// 주요 애플리케이션 클래스
public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        ArithmeticCalculator arithmeticCalculator = new ArithmeticCalculator();  // 사칙연산 계산기
        CircleCalculator circleCalculator = new CircleCalculator();  // 원 계산기

        while (running) {
            System.out.print("사칙연산, 원의 넓이, 또는 모든 결과 보기 중 선택 (사칙연산은 'arith', 원의 넓이는 'circle', 결과 보기는 'inquiry'): ");
            String operationType = sc.next();  // 선택된 옵션

            if (operationType.equalsIgnoreCase("arith")) {  // 사칙연산
                System.out.print("첫 번째 숫자를 입력하세요: ");
                double firstNumber = sc.nextDouble();  // 첫 번째 숫자

                System.out.print("두 번째 숫자를 입력하세요: ");
                double secondNumber = sc.nextDouble();  // 두 번째 숫자

                System.out.print("사칙연산 기호를 입력하세요. (+, -, *, /, %): ");
                char operator = sc.next().charAt(0);  // 연산 기호 입력

                try {
                    double result = arithmeticCalculator.calculate(firstNumber, secondNumber, operator);  // 사칙연산 수행
                    System.out.println("결과: " + result);  // 결과 출력

                    System.out.println("더 계산하시겠습니까? 아무거나 입력하세요. (exit 입력 시 종료): ");  // 종료 확인
                    String response = sc.next();  // 입력
                    if (response.equalsIgnoreCase("exit")) {
                        running = false;  // 프로그램 종료
                    }
                } catch (Exception e) {  // 예외 처리
                    System.out.println("오류: " + e.getMessage());
                }
            } else if (operationType.equalsIgnoreCase("circle")) {  // 원의 넓이
                System.out.print("원의 반지름을 입력하세요: ");
                double radius = sc.nextDouble();  // 반지름 입력

                double area = circleCalculator.calculateCircleArea(radius);  // 원의 넓이 계산
                System.out.println("결과: " + area);  // 결과 출력

                System.out.println("더 계산하시겠습니까? 아무거나 입력하세요. (exit 입력 시 종료): ");  // 종료 확인
                String response = sc.next();  // 입력
                if (response.equalsIgnoreCase("exit")) {  // 종료 조건
                    running = false;  // 프로그램 종료
                }
            } else if (operationType.equalsIgnoreCase("inquiry")) {  // 모든 결과 보기
                System.out.println("모든 저장된 결과: ");

                System.out.print("사칙연산 결과: ");  // 사칙연산 결과
                for (double res : arithmeticCalculator.getAllResults()) {  // 모든 결과 출력
                    System.out.print(res + " ");
                }
                System.out.println();  // 줄바꿈

                System.out.print("원의 넓이 결과: ");  // 원의 넓이 결과
                for (double circleArea : circleCalculator.getAllResults()) {  // 모든 결과 출력
                    System.out.print(circleArea + " ");
                }
                System.out.println();  // 줄바꿈

                System.out.println("계속하시겠습니까? 아무거나 입력하세요. (exit 입력 시 종료): ");  // 종료 확인
                String response = sc.next();  // 입력
                if (response.equalsIgnoreCase("exit")) {  // 종료 조건
                    running = false;  // 프로그램 종료
                }
            }
        }

        sc.close();  // 스캐너 닫기
    }
}
