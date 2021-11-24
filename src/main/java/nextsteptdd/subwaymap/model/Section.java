package nextsteptdd.subwaymap.model;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Section {

    private Line line;
    private LinkedList<Station> stations;

    {
        stations = new LinkedList<>();
    }

    public Section(String name, String ascendingStationName, String descendingStationName) {
        this.line = new Line(name);
        stations.add(new Station(ascendingStationName));
        stations.add(new Station(descendingStationName));
    }

    public Section(String stationName, int order) {
        stations.add(order, new Station(stationName));
    }

    public Section(String lineName, List<Station> stations) {
        this.line = new Line(lineName);
        this.stations.addAll(stations);
    }

    public Line getLine() {
        return line;
    }

    public List<Station> getStations() {
        return stations;
    }

    @Override
    public String toString() {
        return "Section{" +
                "line=" + line +
                ", stations=" + stations +
                '}';
    }
}
