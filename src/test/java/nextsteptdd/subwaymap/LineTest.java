package nextsteptdd.subwaymap;

import nextsteptdd.subwaymap.domain.Line;
import nextsteptdd.subwaymap.domain.LineRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LineTest {

    List<Line> lines;

    @BeforeEach
    void setUp() {
        lines = LineRepository.lines();
    }

    @AfterEach
    void tearDown() {
        LineRepository.initData();
    }

    @Test
    void 지하철노선_조회() {
        assertThat(lines).contains(
                new Line("2호선"),
                new Line("3호선"),
                new Line("신분당선")
        );
    }

    @Test
    void 지하철노선_등록() {
        LineRepository.addLine(new Line("9호선"));
        assertThat(lines).contains(
                new Line("9호선")
        );
    }

    @Test
    void 지하철노선_삭제() {
        LineRepository.deleteLineByName("신분당선");
        assertThat(lines).doesNotContain(
                new Line("신분당선")
        );
    }

    @Test
    void 지하철노선_중복된이름_등록안됨() {
        assertThatThrownBy(() -> LineRepository.addLine(new Line("신분당선"))).isInstanceOf(RuntimeException.class);
    }
}