package nextsteptdd.subwaymap.domain;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Line {

    private static final int MIN_NUM_OF_LINE_NAME = 2;
    private static final String ERROR_LINE_NAME_MIN = "역 이름은 2글자 이상이어야 합니다.";

    private final String name;
    private String ascendingStationName;
    private String descendingStationName;

    private LinkedList<Station> stations = new LinkedList<>();

    public Line(String name) {
        validateName(name);
        this.name = name;
    }

    public Line(String name, String ascendingStationName, String descendingStationName) {
        this.name = name;
        this.ascendingStationName = ascendingStationName;
        this.descendingStationName = descendingStationName;
//        stations.add(new Station(ascendingStationName));
//        stations.add(new Station(descendingStationName));
    }

    public Line(String name, List<Station> stations) {
        validateName(name);
        this.name = name;
        this.stations.addAll(stations);
    }

    public LinkedList<Station> getStations() {
        return stations;
    }

    private void validateName(String name) {
        if (name.length() < MIN_NUM_OF_LINE_NAME) {
            throw new IllegalArgumentException(ERROR_LINE_NAME_MIN);
        }
    }

    public String getName() {
        return name;
    }

    public void addStation(String stationName, int order) {
        stations.add(order, new Station(stationName));
    }

    @Override
    public String toString() {
        return "SubwayLine{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Line)) return false;
        Line that = (Line) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
