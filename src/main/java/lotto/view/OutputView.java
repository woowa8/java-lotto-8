package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.WinningInfo;
import lotto.domain.WinningStats;

public class OutputView {
    public void printLottos(Lottos lottos) {
        System.out.println(lottos.getSize() + "개를 구매했습니다.");
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto.toString());
        }
    }

    public void printStats(WinningStats winningStats, int purchasePrice) {
        System.out.println("당첨 통계");
        System.out.println("---");

        for (WinningInfo info : WinningInfo.values()) {
            if("논외".equals(info.getRank())){
                continue;
            }
            printInformation(info, winningStats);
        }
        System.out.println("총 수익률은 " + winningStats.calculateROR(purchasePrice) + "%입니다.");
    }

    private void printInformation(WinningInfo info, WinningStats winningStats) {
        String money = String.format("%,d", info.getPrize());    // TODO : 숫자 끊어서 작성하는 방법 잊지말기
        if (info.isBonus()) {
            System.out.println(info.getNumberCnt() + "개 일치, 보너스 볼 일치 (" + money + "원) - " + winningStats.getCount(info) + "개");
        }

        System.out.println(info.getNumberCnt() + "개 일치 (" + money + "원) - " + winningStats.getCount(info) + "개");
    }
}
