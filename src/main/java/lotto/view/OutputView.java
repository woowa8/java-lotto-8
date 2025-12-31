package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;

/*
- [ ] 첫 번째 출력은 구매한 로또를 출력한다.
- [ ] 두 번째 출력은 결과 통계를 출력한다.


8개를 구매했습니다.
[8, 21, 23, 41, 42, 43]
[3, 5, 11, 16, 32, 38]
[7, 11, 16, 35, 36, 44]
[1, 8, 11, 31, 41, 42]
[13, 14, 16, 38, 42, 45]
[7, 11, 30, 40, 42, 43]
[2, 13, 22, 32, 38, 45]
[1, 3, 5, 14, 22, 45]
 */
public class OutputView {
    public void printLottos(Lottos lottos) {
        System.out.println(lottos.getSize() + "개를 구매했습니다.");
        for (Lotto lotto : lottos.getLottos()){
            System.out.println(lotto.toString());
        }
    }
}
