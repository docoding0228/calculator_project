package calculator_level2;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Calculator calculator = new Calculator(); // Calculator 인스턴스 생성

        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.print("첫 번째 숫자를 입력하세요 (또는 'exit', 'remove', 'inquiry' 중 하나 입력): ");
            String firstInput = sc.next(); // 사용자 입력받기

            // "exit"가 입력되면 프로그램 종료
            if (firstInput.equalsIgnoreCase("exit")) {
                System.out.println("프로그램을 종료합니다.");
                running = false;
                continue; // 루프 종료
            }

            // "remove"가 입력되면 가장 오래된 결과 삭제
            if (firstInput.equalsIgnoreCase("remove")) {
                if (calculator.removeOldestResult()) {
                    System.out.println("가장 오래된 결과가 삭제되었습니다.");
                } else {
                    System.out.println("삭제할 결과가 없습니다.");
                }
                continue; // 다음 반복으로
            }

            // "inquiry"가 입력되면 저장된 결과 출력
            if (firstInput.equalsIgnoreCase("inquiry")) {
                System.out.println("저장된 결과: ");
                for (Integer result : calculator.getResults()) { // 결과 출력
                    System.out.print(result + " "); // 향상된 for문
                }
                System.out.println(); // 줄바꿈
                continue; // 다음 반복으로
            }

            System.out.print("두 번째 숫자를 입력하세요: ");
            int secondNumber = sc.nextInt();

            System.out.print("사칙연산 기호를 입력하세요: ");
            char operator = sc.next().charAt(0);

            try {
                int firstNumber = Integer.parseInt(firstInput);
                int result = calculator.calculate(firstNumber, secondNumber, operator); // 연산 수행
                System.out.println("결과: " + result);

                System.out.println("더 계산하시겠습니까? (exit 입력 시 종료): ");
                String response = sc.next(); // 사용자 입력
                if (response.equalsIgnoreCase("exit")) {
                    running = false; // 프로그램 종료
                }
            } catch (Exception e) {
                System.out.println("오류: " + e.getMessage());
            }
        }
    }
}
