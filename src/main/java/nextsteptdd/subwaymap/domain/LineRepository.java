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
        lines = new ArrayList<>();
        lines.add(new Line("2호선"));
        lines.add(new Line("3호선"));
        lines.add(new Line("신분당선"));
    }

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }
}
