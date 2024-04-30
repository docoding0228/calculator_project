package calculator_level2;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculator calculator = new Calculator(); // Calculator 객체 생성
        boolean running = true;

        while (running) {
            System.out.print("첫 번째 숫자를 입력하세요 (또는 'exit', 'remove', 'inquiry' 중 하나 입력): ");
            String firstInput = sc.next();

            if (firstInput.equalsIgnoreCase("exit")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            if (firstInput.equalsIgnoreCase("remove")) {
                if (calculator.removeOldestResult()) {
                    System.out.println("가장 오래된 결과가 삭제되었습니다.");
                } else {
                    System.out.println("삭제할 결과가 없습니다.");
                }
                continue; // 다음 루프를 위해 계속 진행
            }

            if (firstInput.equalsIgnoreCase("inquiry")) {
                var results = calculator.getResults();
                if (results.isEmpty()) {
                    System.out.println("저장된 결과가 없습니다.");
                } else {
                    System.out.print("저장된 결과: ");
                    for (Integer res : results) {
                        System.out.print(res + " ");
                    }
                    System.out.println();
                }
                continue; // 다음 루프를 위해 계속 진행
            }

            try {
                int firstNumber = Integer.parseInt(firstInput);

                System.out.print("두 번째 숫자를 입력하세요: ");
                int secondNumber = sc.nextInt();

                System.out.print("사칙연산 기호를 입력하세요: ");
                char operator = sc.next().charAt(0);

                int result = calculator.calculate(firstNumber, secondNumber, operator);
                System.out.println("결과: " + result);

                // 더 계산할지 묻기
                System.out.print("더 계산하시겠습니까? (exit 입력 시 종료): ");
                String response = sc.next(); // 사용자 입력

                if (response.equalsIgnoreCase("exit")) {
                    System.out.println("프로그램을 종료합니다.");
                    break; // 루프 종료
                }

            } catch (Exception e) {
                System.out.println("오류: " + e.getMessage());
            }
        }
    }
}