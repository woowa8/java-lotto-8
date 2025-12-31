package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers.stream().sorted().toList();
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDifferent(numbers);
        for (Integer number : numbers) {
            validateRange(number);
        }
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호의 범위는 1~45입니다.");
        }
    }

    private void validateDifferent(List<Integer> numbers) {
        Set<Integer> numberSet = new HashSet<>(numbers);
        if (numberSet.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 전부 다 달라야 합니다.");
        }
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    public int getContainCnt(Lotto other){
        return (int) numbers.stream().filter(other::contains).count();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public String toString(){
        return numbers.toString();
    }
}
