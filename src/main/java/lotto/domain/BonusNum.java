package lotto.domain;

public class BonusNum {
    private int bonusNum;

    public BonusNum(int bonusNum) {
        validateRange(bonusNum);
        this.bonusNum = bonusNum;
    }

    private void validateRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호의 범위는 1~45입니다.");
        }
    }

    public int getBonusNum() {
        return bonusNum;
    }
}
