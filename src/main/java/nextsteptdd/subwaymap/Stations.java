package nextsteptdd.subwaymap;

import java.util.ArrayList;
import java.util.List;

public class Stations {

    List<Station> stations;

    {
        stations = new ArrayList<>();
        stations.add(new Station("교대역"));
        stations.add(new Station("강남역"));
        stations.add(new Station("역삼역"));
        stations.add(new Station("남부터미널역"));
        stations.add(new Station("양재역"));
        stations.add(new Station("양재시민의숲역"));
        stations.add(new Station("매봉역"));
    }

    public List<Station> get() {
        return stations;
    }

    public void add(String name) {
        stations.add(new Station(name));
    }
}
