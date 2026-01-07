package lotto.domain;

public enum WinningInfo {
    NONE("논외", 0, false, 0),
    FIFTH("5등", 3, false, 5_000),
    FOURTH("4등", 4, false, 50_000),
    THIRD("3등", 5, false, 1_500_000),
    SECOND("2등", 5, true, 30_000_000),
    FIRST("1등", 6, false, 2_000_000_000);

    private final String rank;
    private final int numberCnt;
    private final boolean bonus;

    private final int prize;

    WinningInfo(String rank, int numberCnt, boolean bonus, int prize) {
        this.rank = rank;
        this.numberCnt = numberCnt;
        this.bonus = bonus;
        this.prize = prize;
    }

    public String getRank() {
        return rank;
    }

    public int getNumberCnt() {
        return numberCnt;
    }

    public boolean isBonus() {
        return bonus;
    }

    public int getPrize() {
        return prize;
    }

    public static WinningInfo matchingScore(int count, boolean bonus) {
        if(count == 6 && !bonus){
            return WinningInfo.FIRST;
        }
        if(count == 5 && bonus){
            return WinningInfo.SECOND;
        }
        if(count == 5 && !bonus){
            return WinningInfo.THIRD;
        }
        if(count == 4 && !bonus){
            return WinningInfo.FOURTH;
        }
        if(count == 3 && !bonus){
            return WinningInfo.FIFTH;
        }
        return WinningInfo.NONE;
    }
}