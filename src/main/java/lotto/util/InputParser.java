package lotto.util;

import lotto.domain.Lotto;

import java.util.Arrays;

public class InputParser {

    public Lotto parseNum(String input) {
        String[] parsed = input.split(",");

        for (String parseString : parsed) {
            if (!parseString.matches("[0-9]+")) {
                throw new NumberFormatException("[ERROR] 로또 번호는 반드시 숫자여야 합니다.");
            }
        }

        try {
            return new Lotto(Arrays.stream(parsed).map(Integer::parseInt).toList());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }
}
