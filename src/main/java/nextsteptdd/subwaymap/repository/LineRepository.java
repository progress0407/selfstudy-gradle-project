package nextsteptdd.subwaymap.repository;

import nextsteptdd.subwaymap.model.Line;
import nextsteptdd.subwaymap.model.Station;

import java.util.*;

public class LineRepository {

    private static List<Line> lines;

    public static void addLine(Line line) {
        validateAlreadyLineExist(line);
        lines.add(line);
    }

    public static void validateAlreadyLineExist(Line line) {
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
        lines = new LinkedList<>(List.of(
                new Line("2호선"),
                new Line("3호선"),
                new Line("신분당선")
        ));
        
    }

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static Line findLineByName(String lineName) {
        return lines.stream()
                .filter(e -> e.getName().equals(lineName))
                .findAny()
                .orElseThrow(() -> new RuntimeException("[ERROR] 입력한 호선이 존재하지 않습니다."));
    }
}
