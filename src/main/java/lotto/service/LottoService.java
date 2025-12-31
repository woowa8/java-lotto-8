package lotto.service;

import lotto.domain.*;

public class LottoService {
    public Lottos purchase(int purchaseAmount) {
        return new Lottos(purchaseAmount/1000);
    }

    public WinningStats stats(Lottos lottos, WinningNumber winningNumber, WinningStats stats) {
        for(Lotto lotto : lottos.getLottos()){
            WinningInfo info = winningNumber.getWinningInfo(lotto);    // TODO : ENUM 조합하는 법 알아두기
            stats.add(info);
        }
        return stats;
    }
}
