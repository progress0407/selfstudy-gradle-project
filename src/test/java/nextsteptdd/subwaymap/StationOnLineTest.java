package nextsteptdd.subwaymap;

import nextsteptdd.subwaymap.domain.Line;
import nextsteptdd.subwaymap.domain.LineRepository;
import nextsteptdd.subwaymap.domain.Station;
import nextsteptdd.subwaymap.domain.StationRepository;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 구간 테스트
 */
public class StationOnLineTest {

    @Test
    void 구간_등록() {
        String lineName = "2호선";
        String stationName = "잠실역";
        int order = 2;
        LineRepository.addStationOnLine(lineName, stationName, order);
        Station addStation = new Station(stationName);
        StationRepository.addStation(addStation);
        List<Station> stations = StationRepository.stations();

        Line findLine = LineRepository.lines().stream()
                .filter(line -> lineName.equals(lineName))
                .findAny().get();

        assertThat(findLine).isEqualTo(new Line(lineName));

        LinkedList<Station> findStations = findLine.getStations();
        Station findStation = findStations.get(order);

        assertThat(findStation).isEqualTo(new Station(stationName));

    }

    @Test
    void 구간_삭제() {

    }
}
