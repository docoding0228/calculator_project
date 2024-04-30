package calculator_level2;

import java.util.ArrayList;
import java.util.List;

// 기반 Calculator 클래스
public class Calculator {
    // 연산 결과를 저장하는 리스트
    protected List<Double> results;

    public Calculator() {
        this.results = new ArrayList<>();
    }

    public List<Double> getAllResults() {
        return results;
    }
}
