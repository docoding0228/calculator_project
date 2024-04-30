package calculator_level2;

// 사칙연산 계산기 클래스, Calculator를 상속받음
public class ArithmeticCalculator extends Calculator {
    public double calculate(double firstNumber, double secondNumber, char operator) throws Exception {
        double result;

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
                    throw new ArithmeticException("나누기에서는 0으로 나눌 수 없습니다.");
                }
                result = firstNumber / secondNumber;
                break;
            default:
                throw new IllegalArgumentException("유효하지 않은 연산 기호입니다.");
        }

        results.add(result); // 연산 결과를 저장
        return result;
    }
}
