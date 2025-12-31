package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.BonusNum;
import lotto.domain.Lotto;
import lotto.util.InputParser;

import java.util.function.Supplier;

public class InputView {

    private final InputParser inputParser;

    public InputView(InputParser inputParser){
        this.inputParser = inputParser;
    }

    public int inputPurchase() {
        return retryOnError(() -> {
            System.out.println("구입금액을 입력해 주세요.");
            String input = Console.readLine();

            if (!input.matches("[0-9]+")) {
                throw new IllegalArgumentException("[ERROR] 금액은 반드시 숫자여야 합니다.");
            }

            if (Integer.parseInt(input) % 1000 != 0) {
                throw new IllegalArgumentException("[ERROR] 구매 금액은 반드시 1000으로 나눠 떨어져야 합니다.");
            }
            return Integer.parseInt(input);
        });
    }

    public Lotto inputWinningLotto() {
        return retryOnError(() -> {
            System.out.println("당첨 번호를 입력해 주세요.");
            String input = Console.readLine();

            return inputParser.parseNum(input);
        });
    }

    public BonusNum inputBonusNum() {
        return retryOnError(() -> {
            System.out.println("보너스 번호를 입력해 주세요.");
            String input = Console.readLine();

            return new BonusNum(Integer.parseInt(input));
        });
    }

    private <T> T retryOnError(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {    // TODO : Supplier로 catch시, 잡지 말아야 할 에러를 잡지 않도록 명확히 IllegalArgumentException를 잡는다.
                System.out.println(e.getMessage());
            }
        }
    }
}
