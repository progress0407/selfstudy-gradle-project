package nextsteptdd.subwaymap.model;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Line {

    private static final int MIN_NUM_OF_LINE_NAME = 2;
    private static final String ERROR_LINE_NAME_MIN = "역 이름은 2글자 이상이어야 합니다.";
    private final String name;


    /**
     * 테스트용 데이터 생성
     * @param name 노선 이름
     */
    public Line(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name.length() < MIN_NUM_OF_LINE_NAME) {
            throw new IllegalArgumentException(ERROR_LINE_NAME_MIN);
        }
    }

    public String getName() {
        return name;
    }


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
