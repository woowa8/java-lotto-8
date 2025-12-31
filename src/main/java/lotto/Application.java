package lotto;

import lotto.domain.*;
import lotto.service.LottoService;
import lotto.util.InputParser;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView(new InputParser());
        LottoService lottoService = new LottoService();
        OutputView outputView = new OutputView();

        // 1. 구입 > lotto print
        int amount = inputView.inputPurchase();
        System.out.println();
        Lottos lottos = lottoService.purchase(amount);
        outputView.printLottos(lottos);
        System.out.println();

        // 2. lotto 등수 맞추기
        Lotto winningLotto = inputView.inputWinningLotto();
        System.out.println();
        BonusNum bonus = inputView.inputBonusNum();
        System.out.println();

        WinningNumber winningNumber = new WinningNumber(winningLotto, bonus);
        WinningStats stats = new WinningStats();
        stats = lottoService.stats(lottos, winningNumber, stats);

        outputView.printStats(stats, amount);
    }
}
