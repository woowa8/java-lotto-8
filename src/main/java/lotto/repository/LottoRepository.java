package lotto.repository;

import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoRepository {
    private final List<Lotto> lottos;

    public LottoRepository() {
        lottos = new ArrayList<Lotto>();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void addLotto(Lotto lotto) {
        lottos.add(lotto);
    }

    public int getLottoAmount() {
        return lottos.size();
    }
}
