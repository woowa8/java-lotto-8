package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.domain.WinningNumber;
import lotto.util.InputParser;

import java.util.List;
import java.util.function.Supplier;

public class InputView {
    private final InputParser inputParser;

    public InputView(InputParser inputParser) {
        this.inputParser = inputParser;
    }

    // 구입 금액을 받는다.
    public int inputPurchase() {
        return retryOnError(() -> {
            System.out.println("구입금액을 입력해 주세요.");
            String input = Console.readLine();

            if (!input.matches("[0-9]+")) {
                throw new IllegalArgumentException("[ERROR] 구매 금액은 숫자여야 합니다.");
            }

            int money = Integer.parseInt(input);
            if (Integer.parseInt(input) % 1000 != 0) {
                throw new IllegalArgumentException("[ERROR] 구매 금액은 천원 단위만 가능합니다.");
            }

            System.out.println();
            return money;
        });
    }

    // 당첨 번호를 받는다. 여기서 Lotto 생성
    public Lotto inputWinningLotto() {
        return retryOnError(() -> {
            System.out.println("당첨 번호를 입력해 주세요.");
            String input = Console.readLine();

            List<String> lottoNumbers = inputParser.parse(input);
            List<Integer> lotto = lottoNumbers.stream().map(Integer::parseInt).toList();

            System.out.println();
            return new Lotto(lotto);
        });
    }

    // 보너스 번호를 받는다. 여기서 WinningNumber 생성
    public WinningNumber inputBonusNumber(Lotto winningLotto) {
        return retryOnError(() -> {
            System.out.println("보너스 번호를 입력해 주세요.");
            String input = Console.readLine();

            if (!input.matches("[0-9]+")) {
                throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자여야 합니다.");
            }

            System.out.println();
            return new WinningNumber(winningLotto, Integer.parseInt(input));
        });
    }

    private <T> T retryOnError(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
