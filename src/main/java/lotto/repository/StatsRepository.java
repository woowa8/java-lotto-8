package lotto.repository;

import lotto.domain.Rank;

import java.util.HashMap;
import java.util.Map;

public class StatsRepository {
    private final Map<Rank, Integer> rankStats;

    public StatsRepository() {
        this.rankStats = new HashMap<>();
        init();    // 키 값 미리 넣기
    }

    public void init(){
        Rank[] values = Rank.values();
        for (Rank rank : values) {
            rankStats.put(rank, 0);
        }
    }

    // count만큼 해당 등수 더하기
    public void addStats(Rank rank, int count) {
        rankStats.put(rank, rankStats.getOrDefault(rank, 0) + count);
    }

    public Map<Rank, Integer> getRankStats() {
        return rankStats;
    }
}
