package nextsteptdd.subwaymap;

import nextsteptdd.subwaymap.domain.SubwayLine;
import nextsteptdd.subwaymap.domain.SubwayLines;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SubwayLineTest {

    SubwayLines subwayLines;
    List<SubwayLine> subwayLineList;

    @BeforeEach
    void setUp() {
        subwayLines = new SubwayLines();
        subwayLineList = subwayLines.get();
    }

    @AfterEach
    void tearDown() {
        subwayLines = null;
        subwayLineList = null;
    }

    @Test
    void 지하철노선_조회() {
        assertThat(subwayLineList).contains(
                new SubwayLine("2호선"),
                new SubwayLine("3호선"),
                new SubwayLine("신분당선")
        );
    }

    @Test
    void 지하철노선_등록() {
        subwayLines.add("9호선");
        assertThat(subwayLineList).contains(
                new SubwayLine("9호선")
        );
    }

    @Test
    void 지하철노선_삭제() {
        subwayLines.remove("신분당선");
        assertThat(subwayLineList).doesNotContain(
                new SubwayLine("신분당선")
        );
    }

    @Test
    void 지하철노선_중복된이름_등록안됨() {

    }
}