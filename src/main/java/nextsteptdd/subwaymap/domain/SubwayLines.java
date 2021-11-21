package nextsteptdd.subwaymap.domain;

import java.util.ArrayList;
import java.util.List;

public class SubwayLines {
    List<SubwayLine> subwayLineList;

    {
        subwayLineList = new ArrayList<>();
        subwayLineList.add(new SubwayLine("2호선"));
        subwayLineList.add(new SubwayLine("3호선"));
        subwayLineList.add(new SubwayLine("신분당선"));
    }

    public List<SubwayLine> get() {
        return subwayLineList;
    }

    public void add(String name) {
        subwayLineList.add(new SubwayLine(name));
    }

    public void remove(String name) {
        subwayLineList.remove(new SubwayLine(name));
    }
}
