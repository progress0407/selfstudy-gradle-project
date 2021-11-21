package nextsteptdd.subwaymap.domain;

import java.util.Objects;

public class Station {

    private static final int MIN_NUM_OF_STATIONS_NAME = 2;
    private static final String ERROR_LINE_NAME_MIN = "역 이름은 2글자 이상이어야 합니다.";

    private String name;

    public Station(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name.length() < MIN_NUM_OF_STATIONS_NAME) {
            throw new IllegalArgumentException(ERROR_LINE_NAME_MIN);
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Station{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Station)) return false;
        Station station = (Station) o;
        return Objects.equals(name, station.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
