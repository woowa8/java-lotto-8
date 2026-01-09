package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.WinningNumber;
import lotto.dto.ResponseDto;
import lotto.repository.LottoRepository;
import lotto.repository.StatsRepository;

import java.util.List;
import java.util.Map;

public class LottoService {
    private LottoRepository lottoRepository;
    private StatsRepository statsRepository;

    public LottoService(LottoRepository lottoRepository, StatsRepository statsRepository) {
        this.lottoRepository = lottoRepository;
        this.statsRepository = statsRepository;
    }

    // 로또 발행하는 로직
    public List<Lotto> createLotto(int amount) {
        for (int i = 0; i < amount; i++) {
            Lotto lotto = new Lotto(createRandomNumber());
            lottoRepository.addLotto(lotto);
        }
        return lottoRepository.getLottos();
    }

    // 랜덤 로또 번호 생성 로직
    private List<Integer> createRandomNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    // 등수 계산 & 통계 로직
    public ResponseDto calculate(int purchase, WinningNumber winningNumber) {
        List<Lotto> lottos = lottoRepository.getLottos();

        for (Lotto lotto : lottos) {
            Rank rank = calculateRank(lotto, winningNumber);
            statsRepository.addStats(rank, 1);
        }

        Map<Rank, Integer> rankStats = statsRepository.getRankStats();

        return new ResponseDto(rankStats, calculateRate(rankStats, purchase));
    }

    private Rank calculateRank(Lotto lotto, WinningNumber winningNumber) {
        int countNum = lotto.countNum(winningNumber.getWinningLotto().getNumbers());
        boolean bonus = false;

        if (countNum == 5) {
            bonus = lotto.contains(winningNumber.getBonusNumber());
        }

        return Rank.calculateRank(countNum, bonus);
    }

    private double calculateRate(Map<Rank, Integer> rankStats, int purchase) {
        double totalGift = 0;
        for (Map.Entry<Rank, Integer> entry : rankStats.entrySet()) {
            totalGift += (entry.getKey().getGift() * entry.getValue());
        }

        return (totalGift / purchase) * 100;
    }
}
