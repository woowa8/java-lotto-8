package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class WinningStats {
    private final Map<WinningInfo, Integer> stats;

    public WinningStats() {
        this.stats = new HashMap<WinningInfo, Integer>();
    }

    public Double calculateROR(int purchaseMoney) {
        double rate = (calculateTotalPrice() / (double) purchaseMoney) * 100;
        return Math.round(rate * 10) / 10.0;  // TODO : 이거 원리 다시보기
    }

    // TODO : 여기 stream 사용하는거 다시 봐야 한다.
    public Double calculateTotalPrice() {
        return stats.entrySet().stream().mapToDouble(
                entry -> entry.getKey().getPrize() * entry.getValue()
        ).sum();
    }

    public Map<WinningInfo, Integer> add(WinningInfo winningInfo) {
        stats.put(winningInfo, stats.getOrDefault(winningInfo, 0) + 1);
        return stats;
    }

    public int getCount(WinningInfo winningInfo) {
        return stats.getOrDefault(winningInfo, 0);
    }
}
