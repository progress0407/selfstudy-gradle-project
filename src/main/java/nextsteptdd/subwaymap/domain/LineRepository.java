package nextsteptdd.subwaymap.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LineRepository {

    private static List<Line> lines;

    public static void addLine(Line line) {
        validateAlreadyLineExist(line);
        lines.add(line);
    }

    public static void addLine(String lineName, String ascendingStationName, String descendingStationName) {
        validateAlreadyLineExist(new Line(lineName));
        Line line = new Line(lineName, ascendingStationName, descendingStationName);
        lines.add(line);
    }

    private static void validateAlreadyLineExist(Line line) {
        if (hasLine(line)) {
            throw new RuntimeException("이미 존재하는 노선입니다.");
        }
    }

    private static boolean hasLine(Line line) {
        return lines.stream().anyMatch(line::equals);
    }

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    static {
        initData();
    }

    public static void initData() {
        lines = new ArrayList<>(List.of(
                new Line("2호선",
                        List.of(new Station("교대역"),
                                new Station("강남역"),
                                new Station("역삼역")
                        )),

                new Line("3호선", List.of(
                        new Station("교대역"),
                        new Station("남부터미널역"),
                        new Station("양재역"),
                        new Station("매봉역")
                )),
                
                new Line("신분당선", List.of(
                        new Station("강남역"),
                        new Station("양재역"),
                        new Station("양재시민의숲역")
                ))
        ));
    }

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    // 구간 추가
    public static void addStationOnLine(String lineName, String stationName, int order) {
        Line findLine = findLineByName(lineName);
        findLine.addStation(stationName, order);
    }

    private static Line findLineByName(String lineName) {
        return lines.stream()
                .filter(e -> e.getName().equals(lineName))
                .findAny()
                .orElseThrow(() -> new RuntimeException("[ERROR] 입력한 호선이 존재하지 않습니다."));
    }
}
