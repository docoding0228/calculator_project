package calculator_level2;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        ArithmeticCalculator arithmeticCalculator = new ArithmeticCalculator();  // 사칙연산 계산기
        CircleCalculator circleCalculator = new CircleCalculator();  // 원 계산기

        while (running) {
            System.out.print("사칙연산, 원의 넓이, 모든 결과 보기 또는 첫 번째 결과 삭제 (사칙연산은 '1', 원의 넓이는 '2', 결과 보기는 '3', 첫 번째 삭제는 '4'): ");
            String operationType = sc.next();  // 선택된 옵션

            if (operationType.equalsIgnoreCase("1")) {  // 사칙연산
                System.out.print("첫 번째 숫자를 입력하세요: ");
                double firstNumber = sc.nextDouble();  // 첫 번째 숫자

                System.out.print("두 번째 숫자를 입력하세요: ");
                double secondNumber = sc.nextInt(); // 두 번째 숫자

                System.out.print("사칙연산 기호를 입력하세요. (+, -, *, /, %): ");  // 연산 기호 입력
                char operator = sc.next().charAt(0);

                try {
                    double result = arithmeticCalculator.calculate(firstNumber, secondNumber, operator);  // 연산 수행
                    System.out.println("결과: " + result);  // 결과 출력

                    System.out.println("더 계산하시겠습니까? 아무거나 입력하세요. (exit 입력 시 종료): ");  // 종료 확인
                    String response = sc.next();  // 입력
                    if (response.equalsIgnoreCase("exit")) {  // 종료 조건
                        running = false;  // 프로그램 종료
                    }
                } catch (Exception e) {  // 예외 처리
                    System.out.println("오류: " + e.getMessage());
                }
            } else if (operationType.equalsIgnoreCase("2")) {  // 원의 넓이 또는 둘레
                System.out.print("원의 반지름을 입력하세요: ");  // 반지름 입력
                double radius = sc.nextDouble();

                double area = circleCalculator.calculateCircleArea(radius);  // 원의 넓이 계산
                System.out.println("원의 넓이: " + String.format("%.3f", area));  // 소수점 3자리까지 출력

                System.out.println("더 계산하시겠습니까? 아무거나 입력하세요. (exit 입력 시 종료): ");  // 종료 확인
                String response = sc.next();
                if (response.equalsIgnoreCase("exit")) {
                    running = false;  // 프로그램 종료
                }
            } else if (operationType.equalsIgnoreCase("3")) {  // 모든 결과 보기
                System.out.println("모든 저장된 결과: ");

                System.out.print("사칙연산 결과: ");  // 사칙연산 결과
                for (double res : arithmeticCalculator.getAllResults()) {
                    System.out.print(res + " ");
                }
                System.out.println();  // 줄바꿈

                System.out.print("원의 넓이 결과: ");  // 원의 넓이 결과
                for (double circleArea : circleCalculator.getAllResults()) {
                    System.out.print(String.format("%.3f", circleArea) + " ");  // 소수점 3자리로 포맷
                }
                System.out.println();  // 줄바꿈

                System.out.println("계속하시겠습니까? 아무거나 입력하세요. (exit 입력 시 종료): ");
                String response = sc.next();
                if (response.equalsIgnoreCase("exit")) {
                    running = false;  // 프로그램 종료
                }
            } else if (operationType.equalsIgnoreCase("4")) {  // 첫 번째 결과 삭제
                System.out.println("1" +"은 사칙연산 결과," + "2" + "은 원의 둘레 결과에서 첫 번째 결과를 삭제합니다.");
                int choice = sc.nextInt();  // 사용자 선택

                try {
                    if (choice == 1) {  // 사칙연산 결과에서 첫 번째 삭제
                        arithmeticCalculator.removeFirstResult();
                        System.out.println("사칙연산에서 첫 번째 결과가 삭제되었습니다.");
                    } else if (choice == 2) {  // 원의 둘레 결과에서 첫 번째 삭제
                        circleCalculator.removeFirstResult();
                        System.out.println("원의 둘레에서 첫 번째 결과가 삭제되었습니다.");
                    } else {  // 잘못된 입력
                        System.out.println("유효하지 않은 선택입니다.");
                    }
                } catch (Exception e) {
                    System.out.println("오류: " + e.getMessage());  // 오류 메시지
                }
            }
        }
    }
}
