package calculator_level1;
import java.util.Scanner;
import java.util.Scanner;

    public class App_level1_6 {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            boolean running = true; // 프로그램 실행을 제어하는 플래그

            // 5. Level 1-5 연산 결과 10개를 저장할 수 있는 배열을 선언 및 생성하고 연산의 결과를 저장합니다.
            int[] results = new int[10]; // 연산의 결과를 저장할 수 있도록 적합한 타입의 배열을 생성한다.
            int index = 0; // 연산의 결과가 저장된 배열의 마지막 index를 저장하는 변수를 선언한다.

            while (running) { // 반복문을 통해 무한히 계산을 가능하게 함
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
                boolean effectiveness = true; // 유효성을 체크

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
                // 6. 연산 결과가 10개를 초과하는 경우 가장 먼저 저장된 결과를 삭제하고 새로운 연산 결과가 저장될 수 있도록 소스 코드를 수정합니다.
                // Hint : 결과 값들이 한칸씩 앞으로 이동되면 되지 않을까?
                if (effectiveness) {
                    results[index % results.length] = result; // 원형 큐처럼 동작하는 것을 구현
                    index++;

                    // 저장된 결과 출력
                    System.out.print("저장된 결과: ");
                    int start = index % results.length;
                    for (int i = 0; i < results.length; i++) { // 원형 큐의 순서대로 출력
                        System.out.print(results[(start + i) % results.length] + " ");
                    }
                    System.out.println();
                }
            }
        }
    }


