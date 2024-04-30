package calculator_level1;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App_level1_7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> results = new ArrayList<>(); // 결과를 저장할 컬렉션 사용
        boolean running = true;


        while (running) {
            System.out.print("첫 번째 숫자를 입력하세요 (또는 'exit' 입력시 종료): ");
            String firstInput = sc.next();
            // 4. 반복문을 사용하여 반복의 종료를 알려주는 “exit” 문자열을 입력하기 전까지 무한으로 계산을 진행할 수 있도록 소스 코드를 수정합니다.
            // 사용자가 "exit"을 입력하면 프로그램 종료 또는 숫자를 입력 시 진행

            if (firstInput.equalsIgnoreCase("exit")) {
                running = false; // 프로그램 종료
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            int firstNumber = Integer.parseInt(firstInput); // 첫번째 숫자를 정수로 변환

            System.out.print("두 번째 숫자를 입력하세요: ");
            int secondNumber = sc.nextInt(); // 두번째 숫자를 입력 받음

            // 2. Scanner를 사용하여 사칙연산 기호를 전달 받을 수 있습니다.
            System.out.print("사칙연산 기호를 입력하세요: ");
            char operator = sc.next().charAt(0);

            // 3. 입력받은 양의 정수 2개와 사칙연산 기호를 사용하여 연산을 진행한 후 결과값을 출력
            boolean effectiveness = true; // 유효성 체크
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

                // 컬렉션에 저장된 모든 결과를 출력
                System.out.print("저장된 결과: ");
                for (Integer res : results) { // 결과 리스트를 순회
                    System.out.print(res + " ");
                }
                System.out.println(); // 줄바꿈

                System.out.println("가장 먼저 저장된 연산 결과를 삭제하시겠습니까? (remove 입력 시 삭제): "); // remove
                System.out.println("삭제를 원치 않으시다면 아무거나 입력해주세요.");// 종료를 원치 않을 시
                String removeInput = sc.next(); // 삭제 여부 확인

                if (removeInput.equalsIgnoreCase("remove")) {
                    if (!results.isEmpty()) {
                        results.remove(0); // 가장 오래된 결과 삭제
                        System.out.println("가장 오래된 결과가 삭제되었습니다.");
                    } else {
                        System.out.println("삭제할 결과가 없습니다.");
                    }
                }
                System.out.println("더 계산하시겠습니까? (exit 입력 시 종료): ");// 종료 여부 확인
                System.out.println("배열을 더 추가하시려면 아무거나 입력해주세요.");// 종료를 원치않을 시

                String continueInput = sc.next(); // 사용자 입력

                if (continueInput.equalsIgnoreCase("exit")) {
                    running = false; // 프로그램 종료
                    System.out.println("프로그램을 종료합니다.");
                }
            }
        }
        sc.close(); // Scanner 리소스 해제
    }
}
