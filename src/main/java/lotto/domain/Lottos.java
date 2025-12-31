package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

/**
 * 로또 여러개 생성해서 가지는 로직 필요
 */
public class Lottos {
    private final List<Lotto> lottoList;

    public Lottos(int count) {
        lottoList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            lottoList.add(lotto);
        }
    }

    public int getSize(){
        return lottoList.size();
    }

    public List<Lotto> getLottos(){
        return lottoList;
    }
}
