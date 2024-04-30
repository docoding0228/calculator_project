package calculator;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean running = true; // 프로그램 실행을 제어하는 플래그

        while (running) { // 반복문을 통해 무한 계산을 가능하게 함
            // 4. 반복문을 사용하여 반복의 종료를 알려주는 “exit” 문자열을 입력하기 전까지 무한으로 계산을 진행할 수 있도록 소스 코드를 수정합니다.
            // 사용자가 "exit"을 입력하면 프로그램 종료 또는 숫자를 입력 시 진행
            System.out.print("첫 번째 숫자를 입력하세요 (또는 'exit' 입력시 종료): ");
            String firstInput = sc.next(); // 입력 받음

            if (firstInput.equalsIgnoreCase("exit")) {
                running = false;
                System.out.println("프로그램을 종료합니다.");
                break;
            }
            int firstNumber = Integer.parseInt(firstInput); // 첫번째 숫자를 정수로 변환

            System.out.print("두 번째 숫자를 입력하세요: ");
            int secondNumber = sc.nextInt(); // 두번째 숫자를 입력 받음

            // 2. Scanner를 사용하여 사칙연산 기호를 전달 받을 수 있습니다.
            System.out.print("사칙연산 기호를 입력하세요: ");
            char operator = sc.next().charAt(0); // 입력받은 문자열의 첫 번째 문자 추출

            // 3. 입력받은 양의 정수 2개와 사칙연산 기호를 사용하여 연산을 진행한 후 결과값을 출력
            int result = 0;
            boolean effectiveness = true; // 연산의 유효성을 체크

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
                case '/': // 나눗셈
                    if (secondNumber == 0) {
                        System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                        effectiveness = false; // 무효 연산 플래그 설정
                    } else {
                        result = firstNumber / secondNumber;
                    }
                    break;
                default:
                    System.out.println("유효하지 않은 연산자입니다.");
                    effectiveness = false; // 무효 연산 플래그 설정
                    break;
            }
            if (effectiveness) {
                System.out.println("결과: " + result);
            }
        }
        sc.close(); // Scanner 리소스 해제
    }
}
