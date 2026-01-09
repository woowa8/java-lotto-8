package lotto.dto;

import lotto.domain.Rank;
import java.util.Map;

public record ResponseDto(
        Map<Rank, Integer> rankStats,
        Double rate
) {
}
