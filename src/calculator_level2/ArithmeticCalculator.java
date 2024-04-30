package calculator_level2;

// 사칙연산 계산기 클래스, Calculator를 상속받음
public class ArithmeticCalculator extends Calculator {

    public double calculate(double firstNumber, double secondNumber, char operator) throws Exception {
        Operator op;  // 연산 객체 변수

        switch (operator) {
            case '+':
                op = new AddOperator();  // 더하기 연산 객체
                break;
            case '-':
                op = new SubtractOperator();  // 빼기 연산 객체
                break;
            case '*':
                op = new MultiplyOperator();  // 곱하기 연산 객체
                break;
            case '/':
                op = new DivideOperator();  // 나누기 연산 객체
                break;
            case '%':
                op = new ModOperator();  // 나머지 연산 객체
                break;
            default:
                throw new IllegalArgumentException("유효하지 않은 연산 기호입니다.");  // 유효하지 않은 연산 기호 예외
        }

        double result = op.operate(firstNumber, secondNumber);  // 연산 수행
        results.add(result);  // 결과 저장
        return result;  // 결과 반환
    }
}
