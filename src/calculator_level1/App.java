package calculator_level1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> results = new ArrayList<>(); // 결과를 저장할 컬렉션 사용
        boolean running = true;

        while (running) {
            System.out.print("첫 번째 숫자를 입력하세요 (또는 'exit', 'remove', 'inquiry' 중 하나 입력): ");
            String firstInput = sc.next(); // 입력받기

            if (firstInput.equalsIgnoreCase("exit")) {
                running = false; // 프로그램 종료
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            if (firstInput.equalsIgnoreCase("remove")) {
                if (!results.isEmpty()) {
                    results.remove(0); // 가장 오래된 결과 삭제
                    System.out.println("가장 오래된 결과가 삭제되었습니다.");
                } else {
                    System.out.println("삭제할 결과가 없습니다.");
                }
                continue; // "remove" 입력 시 연산 건너뛰기
            }

            // 8. Level 1-8 inquiry”라는 문자열이 입력되면 저장된 연산 결과 전부를 출력합니다.
            if (firstInput.equalsIgnoreCase("inquiry")) { // "inquiry" 입력 시 결과 출력
                if (results.isEmpty()) {
                    System.out.println("저장된 결과가 없습니다.");
                } else {
                    System.out.print("저장된 결과: "); // 결과 출력
                    for (Integer res : results) { // 결과 리스트 순회
                        System.out.print(res + " ");
                    }
//                    for (int i = 0; i < results.size(); i++) { // 일반 for문 사용
//                        System.out.print(results.get(i) + " ");
//                    }
                    System.out.println(); // 줄바꿈
                }
                continue; // "inquiry" 입력 시 다음 반복으로
            }

            int firstNumber = Integer.parseInt(firstInput);

            System.out.print("두 번째 숫자를 입력하세요: ");
            int secondNumber = sc.nextInt();

            System.out.print("사칙연산 기호를 입력하세요: ");
            char operator = sc.next().charAt(0);

            boolean effectiveness = true;
            int result = 0;

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
                        System.out.println("나눗셈 연산에서 분모에 0이 입력될 수 없습니다.");
                        effectiveness = false;
                    } else {
                        result = firstNumber / secondNumber;
                    }
                    break;
                default:
                    System.out.println("유효하지 않은 연산자입니다.");
                    effectiveness = false;
                    break;
            }

            if (effectiveness) {
                results.add(result); // 결과를 컬렉션에 추가
                System.out.println("결과: " + result); // 현재 연산 결과 출력
            }
        }
    }
}
