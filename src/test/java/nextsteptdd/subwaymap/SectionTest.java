package nextsteptdd.subwaymap;

import nextsteptdd.subwaymap.model.Line;
import nextsteptdd.subwaymap.model.Section;
import nextsteptdd.subwaymap.model.Station;
import nextsteptdd.subwaymap.repository.LineRepository;
import nextsteptdd.subwaymap.repository.SectionRepository;
import nextsteptdd.subwaymap.repository.StationRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 구간 테스트
 */
public class SectionTest {

    @AfterEach
    void tearDown() {
        SectionRepository.initData();
        LineRepository.initData();
        StationRepository.initData();
    }

    @Test
    void 이미있는_구간_등록() {
        String lineName = "2호선";
        String stationName = "잠실역";
        int stationOrder = 2;
        SectionRepository.addSection(lineName, stationName, stationOrder);

        Line findLine = LineRepository.findLineByName(lineName);
        assertThat(findLine).isEqualTo(new Line(lineName));

        Section findSection = SectionRepository.findSectionByLineName(lineName);
        Station findStation = findSection.getStations().get(stationOrder);
        assertThat(findStation).isEqualTo(new Station("잠실역"));
    }

    @Test
    void 새로운_노선_구간등록() {

        String lineName = "7호선";
        String ascendingStationName = "장승배기역";
        String descendingStationName = "이수역";
        String stationName = "상도역";
        int stationOrder = 1;


        // 새로운 호선 등록
        LineRepository.addLine(new Line(lineName));
        SectionRepository.addSection(lineName, ascendingStationName, descendingStationName);
        SectionRepository.addSection(lineName, stationName, stationOrder);
        Section findSection = SectionRepository.findSectionByLineName(lineName);

        assertThat(findSection.getLine()).isEqualTo(new Line("7호선"));
        assertThat(findSection.getStations())
                .containsExactly(
                        new Station("장승배기역"),
                        new Station("상도역"),
                        new Station("이수역")
                );
    }

    @Test
    void 구간_삭제() {
        String lineName = "";
        String staionName = "";
        SectionRepository.deleteSection(lineName, staionName);
    }
}
