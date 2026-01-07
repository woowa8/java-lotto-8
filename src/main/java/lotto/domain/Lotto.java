package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers.stream().sorted().toList();    // 정렬해서 저장
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public String toString() {
        return numbers.toString();
    }

    public int countNum(List<Integer> compareNumber) {
        int count = 0;
        for(Integer compare : compareNumber) {
            if(this.numbers.contains(compare))
                count++;
        }
        return count;
    }

    public boolean contains(int number) {
        return this.numbers.contains(number);
    }

    private void validate(List<Integer> numbers) {
        validateCount(numbers);
        validateRange(numbers);
        validateDuplicate(numbers);
    }

    private void validateCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number > 45 || number < 1) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1~45 사이의 숫자여야 합니다.");
            }
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);

        if (set.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복된 숫자일 수 없습니다.");
        }
    }
}
