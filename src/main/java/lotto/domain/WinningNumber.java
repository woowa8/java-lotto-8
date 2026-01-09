package lotto.domain;

public class WinningNumber {
    private final Lotto lotto;
    private final int bonusNumber;

    public WinningNumber(Lotto lotto, int bonusNumber) {
        validateRange(bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    private void validateRange(int number) {
        if (number > 45 || number < 1) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1~45 사이의 숫자여야 합니다.");
        }
    }

    public Lotto getWinningLotto() {
        return lotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
