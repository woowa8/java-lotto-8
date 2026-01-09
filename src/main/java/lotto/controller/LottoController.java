package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.WinningNumber;
import lotto.repository.LottoRepository;
import lotto.repository.StatsRepository;
import lotto.service.LottoService;
import lotto.util.InputParser;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;

    public LottoController() {
        InputParser inputParser = new InputParser();
        inputView = new InputView(inputParser);
        outputView = new OutputView();

        lottoService = new LottoService(new LottoRepository(), new StatsRepository());
    }

    // run으로 실행하는 로직
    public void run() {
        int purchase = inputView.inputPurchase();
        int count = purchase / 1000;
        List<Lotto> lottos = lottoService.createLotto(count);
        outputView.printLottos(lottos, count);

        Lotto winningLotto = inputView.inputWinningLotto();
        WinningNumber winningNumber = inputView.inputBonusNumber(winningLotto);

        outputView.printStats(lottoService.calculate(purchase, winningNumber));
    }
}
