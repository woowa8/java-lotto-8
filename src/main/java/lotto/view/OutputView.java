package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.dto.ResponseDto;

import java.util.List;

public class OutputView {
    // 랜덤 생성된 로또 리스트 출력
    public void printLottos(List<Lotto> lottos, int count) {
        System.out.println(count + "개를 구매했습니다.");
        System.out.println(toStringLottos(lottos));
    }

    private String toStringLottos(List<Lotto> lottos) {
        StringBuilder sb = new StringBuilder();
        for (Lotto lotto : lottos) {
            sb.append(lotto.toString() + "\n");
        }
        return sb.toString();
    }

    // 로또 결과 출력
    public void printStats(ResponseDto dto) {
        System.out.println("당첨 통계");
        System.out.println("---");
        for(Rank rank : Rank.values()) {
            if("꽝".equals(rank.getRankName())){    // 꽝은 프린트 안함
                continue;
            }
            System.out.println(toStringRankStats(rank, dto));
        }
        System.out.println("총 수익률은 " + (Math.round(dto.rate() * 100) / 100.0) + "%입니다.");

        System.out.println();
    }

    private String toStringRankStats(Rank rank, ResponseDto dto) {
        StringBuilder sb = new StringBuilder();

        // TODO : 원래 if-else 안쓰는건데 우선 이렇게 함
        if(rank.isBonus()){
            sb.append(rank.getCorrectNum() + "개 일치, 보너스 볼 일치 ");
        }else{
            sb.append(rank.getCorrectNum() + "개 일치 ");
        }
        sb.append("(" + String.format("%,d", rank.getGift()) + "원) - ");
        sb.append(dto.rankStats().get(rank) + "개");

        return sb.toString();
    }
}
