package calculator_level2;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // 2-3 App 클래스의 main 메서드에서 Calculator 클래스의 연산 결과를 저장하고 있는 컬렉션 필드에 직접 접근하지 못하도록 수정합니다.
        Calculator calculator = new Calculator(); // Calculator 인스턴스 생성

        Scanner sc = new Scanner(System.in);
        boolean running = true;

        // 7. Calculator 클래스에 반지름을 매개변수로 전달받아 원의 넓이를 계산하여 반환해주는 메서드를 구현합니다.
        while (running) {
            System.out.print("사칙연산 또는 원의 넓이 계산 중 선택 (연산은 'oper', 원의 넓이는 'circle'): ");
            String operationType = sc.next(); // 어떤 작업을 할지 선택

            if (operationType.equalsIgnoreCase("oper")) { // 사칙연산 선택
                System.out.print("첫 번째 숫자를 입력하세요 (또는 'exit', 'remove', 'inquiry' 중 하나 입력): ");
                String firstInput = sc.next();

                if (firstInput.equalsIgnoreCase("exit")) {
                    System.out.println("프로그램을 종료합니다.");
                    running = false; // 프로그램 종료
                    continue;
                }
                // 2-5
                if (firstInput.equalsIgnoreCase("inquiry")) {
                    System.out.println("저장된 결과: ");
                    for (Integer result : calculator.getAllResults()) { // 결과 리스트 순회
                        System.out.print(result + " "); // 향상된 for문을 활용한 결과 출력
                    }
                    System.out.println(); // 줄바꿈
                    continue; // 다음 반복
                }
                // 2-4
                if (firstInput.equalsIgnoreCase("remove")) {
                    if (calculator.removeOldestResult()) {
                        System.out.println("가장 오래된 결과가 삭제되었습니다.");
                    } else {
                        System.out.println("삭제할 결과가 없습니다.");
                    }
                    continue; // 다음 반복
                }
                // 2-2 Level 1에서 구현한 App 클래스의 main 메서드에 Calculator 클래스가 활용될 수 있도록 수정합니다.
                int firstNumber = Integer.parseInt(firstInput);

                System.out.print("두 번째 숫자를 입력하세요: ");
                int secondNumber = sc.nextInt();

                System.out.print("사칙연산 기호를 입력하세요: ");
                char operator = sc.next().charAt(0);

                try {
                    int result = calculator.calculate(firstNumber, secondNumber, operator); // 연산 수행
                    System.out.println("결과: " + result);

                    System.out.println("더 계산하시겠습니까? 진행을 원하시면 아무거나 입력해주세요. (exit 입력 시 종료):  ");
                    String response = sc.next(); // 사용자 입력
                    if (response.equalsIgnoreCase("exit")) {
                        running = false; // 프로그램 종료
                    }
                } catch (Exception e) {
                    System.out.println("오류: " + e.getMessage());
                }
                // 2-7
            } else if (operationType.equalsIgnoreCase("circle")) { // 원의 넓이 계산 선택
                System.out.print("원의 반지름을 입력하세요: ");
                double radius = sc.nextDouble(); // 원의 반지름 입력

                double area = calculator.calculateCircleArea(radius); // 원의 넓이 계산
                System.out.println("원의 넓이: " + area); // 결과 출력

                System.out.println("저장된 원의 넓이 결과: ");
                for (Double circleArea : calculator.getAllCircleAreas()) { // 원의 넓이 결과 순회
                    System.out.print(circleArea + " "); // 향상된 for문을 활용한 결과 출력
                }
                System.out.println(); // 줄바꿈

                System.out.println("더 계산하시겠습니까? (exit 입력 시 종료): ");
                String response = sc.next(); // 사용자 입력
                if (response.equalsIgnoreCase("exit")) {
                    running = false; // 프로그램 종료
                }
            }
        }
    }
}
