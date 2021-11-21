package nextsteptdd.subwaymap;

import java.util.ArrayList;
import java.util.List;

public class Stations {

    public static final String ERROR_DUPLICATION_STATION = "이미 동일한 이름의 역이 있습니다.";

    List<Station> stationList;

    {
        stationList = new ArrayList<>();
        stationList.add(new Station("교대역"));
        stationList.add(new Station("강남역"));
        stationList.add(new Station("역삼역"));
        stationList.add(new Station("남부터미널역"));
        stationList.add(new Station("양재역"));
        stationList.add(new Station("양재시민의숲역"));
        stationList.add(new Station("매봉역"));
    }

    public List<Station> get() {
        return stationList;
    }

    public void add(String name) {
        validateAlreadyStationExist(name);
        stationList.add(new Station(name));
    }

    private void validateAlreadyStationExist(String name) {
        if (hasStation(name)) {
            throw new RuntimeException(ERROR_DUPLICATION_STATION);
        }
    }

    private boolean hasStation(String name) {
        return stationList.stream().anyMatch(e -> e.getName().equals(name));
    }

    public void remove(String name) {
        stationList.remove(new Station(name));
    }
}
