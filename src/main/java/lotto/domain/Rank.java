package lotto.domain;

public enum Rank {
    NONE("꽝", 0, false, 0),
    FIFTH("5등", 3, false, 5_000),
    FOURTH("4등", 4, false, 50_000),
    THIRD("3등", 5, false, 1_500_000),
    SECOND("2등", 5, true, 30_000_000),
    FIRST("1등", 6, false, 2_000_000_000);

    private final String rankName;
    private final int correctNum;
    private final boolean isBonus;
    private final int gift;

    Rank(String rankName, int correctNum, boolean isBonus, int gift) {
        this.rankName = rankName;
        this.correctNum = correctNum;
        this.isBonus = isBonus;
        this.gift = gift;
    }

    public String getRankName() {
        return rankName;
    }

    public int getCorrectNum() {
        return correctNum;
    }

    public boolean isBonus() {
        return isBonus;
    }

    public int getGift() {
        return gift;
    }

    // 해당하는 등수 내보내는 로직
    public static Rank calculateRank(int correctNum, boolean isBonus) {
        if (correctNum == 6 && !isBonus) {
            return FIRST;
        }
        if (correctNum == 5 && isBonus) {
            return SECOND;
        }
        if (correctNum == 5 && !isBonus) {
            return THIRD;
        }
        if (correctNum == 4 && !isBonus) {
            return FOURTH;
        }
        if (correctNum == 3 && !isBonus) {
            return FIFTH;
        }
        return NONE;
    }
}
