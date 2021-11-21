package nextsteptdd.subwaymap;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SubwayLineTest {
    @Test
    void 지하철노선_조회() {
        SubwayLines subwayLines = new SubwayLines();
        List<SubwayLine> subwayLineList = subwayLines.get();
        assertThat(subwayLineList).contains(
                new SubwayLine("2호선"),
                new SubwayLine("3호선"),
                new SubwayLine("신분당선")
        );
    }
}