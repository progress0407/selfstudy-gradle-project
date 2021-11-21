package nextsteptdd.subwaymap;

import java.util.Objects;

public class SubwayLine {
    String name;

    public SubwayLine(String name) {
        this.name = name;
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
        if (!(o instanceof SubwayLine)) return false;
        SubwayLine that = (SubwayLine) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
