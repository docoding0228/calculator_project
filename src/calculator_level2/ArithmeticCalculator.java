package calculator_level2;

// 사칙연산 계산기 클래스, Calculator를 상속받음
public class ArithmeticCalculator extends Calculator {
    private AddOperator addOperator;
    private SubtractOperator subtractOperator;
    private MultiplyOperator multiplyOperator;
    private DivideOperator divideOperator;
    private ModOperator modOperator;

    public ArithmeticCalculator() {
        this.addOperator = new AddOperator();  // 더하기 연산 객체
        this.subtractOperator = new SubtractOperator();  // 빼기 연산 객체
        this.multiplyOperator = new MultiplyOperator();  // 곱하기 연산 객체
        this.divideOperator = new DivideOperator();  // 나누기 연산 객체
        this.modOperator = new ModOperator();  // 나머지 연산 객체
    }

    public double calculate(double firstNumber, double secondNumber, char operator) throws Exception {
        double result;

        switch (operator) {
            case '+':
                result = addOperator.add(firstNumber, secondNumber);  // 더하기 연산
                break;
            case '-':
                result = subtractOperator.subtract(firstNumber, secondNumber);  // 빼기 연산
                break;
            case '*':
                result = multiplyOperator.multiply(firstNumber, secondNumber);  // 곱하기 연산
                break;
            case '/':
                result = divideOperator.divide(firstNumber, secondNumber);  // 나누기 연산
                break;
            case '%':
                result = modOperator.mod(firstNumber, secondNumber);  // 나머지 연산
                break;
            default:
                throw new IllegalArgumentException("유효하지 않은 연산 기호입니다.");
        }

        results.add(result);  // 결과 저장
        return result;
    }
}
