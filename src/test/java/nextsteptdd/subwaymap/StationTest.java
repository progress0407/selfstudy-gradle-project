package nextsteptdd.subwaymap;

import nextsteptdd.subwaymap.domain.Station;
import nextsteptdd.subwaymap.domain.StationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StationTest {

    List<Station> stationList;

    @BeforeEach
    void setUp() {
        stationList = StationRepository.stations();
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
        StationRepository.addStation(new Station("노량진역"));
        StationRepository.addStation(new Station("상도역"));
        assertThat(stationList).contains(
                new Station("노량진역")
                , new Station("상도역")
        );
    }

    @Test
    void 지하철_삭제() {
        StationRepository.deleteStation("매봉역");
        assertThat(stationList).doesNotContain(new Station("매봉역"));
    }

    @Test
    void 지하철_이미삭제한경우() {
        boolean firstDelete = StationRepository.deleteStation("역삼역");
        assertThat(firstDelete).isTrue();
        boolean secondDelete = StationRepository.deleteStation("역삼역");
        assertThat(secondDelete).isFalse();
    }

    @Test
    void 이미있는_지하철은_등록이_안된다() {
        assertThatThrownBy(() -> StationRepository.addStation(new Station("교대역"))).isInstanceOf(RuntimeException.class);
    }

    @Test
    void 역이름은_두글자_이상이어야_된다() {
        assertThatThrownBy(() -> StationRepository.addStation(new Station("뀨"))).isInstanceOf(IllegalArgumentException.class);
    }
}