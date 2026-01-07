package lotto.util;

import java.util.Arrays;
import java.util.List;

public class InputParser {
    public List<String> parse(String input) {
        String[] words = input.split(",");
        for (String word : words) {
            if (word.trim().equals("")){
                throw new IllegalArgumentException("[ERROR] 로또 번호는 빈 칸일 수 없습니다.");
            }
            if(!word.matches("[0-9]+")){
                throw new IllegalArgumentException("[ERROR] 로또 번호는 숫자여야 합니다.");
            }
        }
        return Arrays.asList(words);
    }
}
