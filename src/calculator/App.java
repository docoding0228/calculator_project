package calculator;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. Scanner를 사용하여 양의 정수 2개(0 포함)를 전달 받을 수 있습니다.
        System.out.print("첫 번째 숫자를 입력하세요: ");
        System.out.print("두 번째 숫자를 입력하세요: ");

        // 2. Scanner를 사용하여 사칙연산 기호를 전달 받을 수 있습니다.
        System.out.print("사칙연산 기호를 입력하세요: ");
        char operator = sc.next().charAt(0); // 입력 받은 string의 인덱스 0번 char을 가져온다.

    }
}