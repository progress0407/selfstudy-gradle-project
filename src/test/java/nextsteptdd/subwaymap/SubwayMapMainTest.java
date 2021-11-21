package nextsteptdd.subwaymap;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class SubwayMapMainTest {

    Stations stations;
    List<Station> stationList;

    @BeforeEach
    void setUp() {
        stations = new Stations();
        stationList = stations.get();
    }

    @AfterEach
    void tearDown() {
        stations = null;
    }

    @Test
    @DisplayName("지하철 역의 목록을 조회할 수 있다.")
    void 지하철_리스트_조회() {
        // 교대역, 강남역, 역삼역, 남부터미널역, 양재역, 양재시민의숲역, 매봉역

        assertThat(stationList).contains(
                new Station("교대역"),
                new Station("강남역"),
                new Station("역삼역"),
                new Station("남부터미널역"),
                new Station("양재역"),
                new Station("양재시민의숲역"),
                new Station("매봉역")
                );
    }

    @Test
    void 지하철_등록() {
        stations.add("노량진역");
        stations.add("상도역");
        assertThat(stationList).contains(
                new Station("노량진역")
                , new Station("상도역")
        );
    }

    @Test
    void 지하철_삭제() {
        stations.remove("매봉역");
        assertThat(stationList).doesNotContain(new Station("매봉역"));
    }

    @Test
    void 이미있는_지하철은_등록이_안된다() {
        assertThatThrownBy(() -> {
            stations.add("교대역");
        }).isInstanceOf(RuntimeException.class);
    }

    @Test
    void 역이름은_두글자_이상이어야_된다() {
        assertThatThrownBy(() -> {
            stations.add("뀨");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}