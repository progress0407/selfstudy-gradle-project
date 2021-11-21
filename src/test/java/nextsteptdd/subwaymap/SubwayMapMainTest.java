package nextsteptdd.subwaymap;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SubwayMapMainTest {

    @Test
    @DisplayName("지하철 역의 목록을 조회할 수 있다.")
    void 지하철_리스트_조회() {
        // 교대역, 강남역, 역삼역, 남부터미널역, 양재역, 양재시민의숲역, 매봉역
        Stations stations = new Stations();
        List<Station> stationList = stations.get();
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
}