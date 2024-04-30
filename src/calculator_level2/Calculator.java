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

    public double getLatestResult() {
        if (results.isEmpty()) {
            throw new IllegalStateException("저장된 결과가 없습니다.");  // 결과가 없을 때 예외
        }
        return results.get(results.size() - 1);  // 가장 최근 결과 반환
    }

    public void removeFirstResult() {
        if (results.isEmpty()) {
            throw new IllegalStateException("삭제할 결과가 없습니다.");  // 결과가 없을 때 예외
        }
        results.remove(0);  // 가장 처음 저장된 결과 삭제
    }
}
