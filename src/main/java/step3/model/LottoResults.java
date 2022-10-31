package step3.model;

import java.util.ArrayList;
import java.util.List;

public class LottoResults {

    private List<LottoResult> lottoResults;

    public LottoResults() {
        this.lottoResults = new ArrayList<>();
    }

    public LottoResults(List<LottoResult> lottoResults) {
        this.lottoResults = lottoResults;
    }

    public void add(LottoResult lottoResult) {
        this.lottoResults.add(lottoResult);
    }

    public int count() {
        return this.lottoResults.size();
    }

    public LottoResult getResultByIndex(int index) {
        if (count() <= index) {
            throw new RuntimeException("해당 인덱스에 결과가 존재하지않습니다.");
        }

        return this.lottoResults.get(index);
    }

    public double getTotalMoney() {
        double totalMoney = 0.00;
        for (LottoResult lottoResult : this.lottoResults) {
            totalMoney += lottoResult.getScoreMatchedCount() * lottoResult.getTotalMoney();
        }

        return totalMoney;
    }
}
