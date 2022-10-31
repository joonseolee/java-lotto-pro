package step3.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step3.service.LottoScoreType;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {

    private LottoResult lottoResult;

    @BeforeEach
    private void setUp() {
        this.lottoResult = new LottoResult(1,2,3,4);
    }

    @ParameterizedTest
    @CsvSource(value = {"THREE,1", "FOUR,2", "FIVE,3", "SIX,4"})
    @DisplayName("LottoScoreType이 주어질때 결과에서 그에 따른 갯수를 리턴한다.")
    void whenGetByLottoScoreType_thenCount(LottoScoreType scoreType, int expectedCount) {
        int count = lottoResult.getByLottoScoreType(scoreType);

        assertThat(count).isEqualTo(expectedCount);
    }

    @ParameterizedTest
    @CsvSource(value = {"THREE,2", "FOUR,3", "FIVE,4", "SIX,5"})
    @DisplayName("LottoScoreType이 주어질때 결과에서 그에 따른 갯수를 리턴한다.")
    void whenAddByLottoScoreType_thenCount(LottoScoreType scoreType, int expectedTotalCount) {
        lottoResult.addByLottoScoreType(scoreType);

        int count = lottoResult.getByLottoScoreType(scoreType);
        assertThat(count).isEqualTo(expectedTotalCount);
    }

    @ParameterizedTest
    @CsvSource(value = {"5000,0,2,0,0,20", "14000,1,0,0,0,0.35", "14000,0,1,1,0,110.71"})
    @DisplayName("money 에 따라 로또수익률을 확인할때 실수갑으로 리턴한다.")
    void whenGetBenefitRate_thenRate(int money, int threeCount, int fourCount, int fiveCount, int sixCount, double expectedRate) {
        LottoResult simpleLottoResult = new LottoResult(threeCount, fourCount, fiveCount, sixCount);

        double rate = simpleLottoResult.getBenefitRate(money);

        assertThat(rate).isEqualTo(expectedRate);
    }
}