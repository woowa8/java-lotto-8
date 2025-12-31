package lotto.domain;

public class WinningNumber {
    private final Lotto winningLotto;
    private final BonusNum bonus;

    public WinningNumber(Lotto winningLotto, BonusNum bonus) {
        this.winningLotto = winningLotto;
        this.bonus = bonus;
    }

    public WinningInfo getWinningInfo(Lotto other) {
        int count = winningLotto.getContainCnt(other);
        boolean isBonus = winningLotto.contains(bonus.getBonusNum());

        return WinningInfo.matchingScore(count, isBonus);
    }
}
