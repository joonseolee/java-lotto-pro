package step5.model;

import step5.service.LottoScoreType;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class LottoResult {
    private static final double TWO_POINT_POSITION = 100;

    protected Map<LottoScoreType, Integer> winningMap = new EnumMap<>(LottoScoreType.class);

    protected LottoResult(List<LottoScoreType> lottoWinningScoreTypeList) {
        Stream.of(LottoScoreType.values())
                .forEach(type -> winningMap.put(type, 0));
        for (LottoScoreType lottoScoreType : lottoWinningScoreTypeList) {
            winningMap.put(lottoScoreType, winningMap.get(lottoScoreType) + 1);
        }
    }

    public static LottoResult getLottoResultFromLotto(Lottos lottos, LottoWinningNos winningLotto) {
        return new LottoResult(lottos.confirmLottoWinningNumber(winningLotto));
    }

    public int getByLottoScoreType(LottoScoreType scoreType) {
        if (scoreType == null) {
            return 0;
        }
        return winningMap.get(scoreType);
    }

    public void addByLottoScoreType(LottoScoreType scoreType) {
        if (scoreType == null) {
            return;
        }

        winningMap.put(scoreType, winningMap.get(scoreType) + 1);
    }

    public double getProfitRate(int money) {
        int totalBenefit = 0;
        for (LottoScoreType scoreType : LottoScoreType.values()) {
            totalBenefit += (getByLottoScoreType(scoreType) * scoreType.getMoney());
        }

        return Math.floor(((double) totalBenefit / money * TWO_POINT_POSITION)) / TWO_POINT_POSITION;
    }
}