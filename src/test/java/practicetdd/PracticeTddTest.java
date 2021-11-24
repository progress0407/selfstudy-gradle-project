package practicetdd;

import nextsteptdd.subwaymap.model.Line;
import nextsteptdd.subwaymap.model.Section;
import nextsteptdd.subwaymap.model.Station;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static java.lang.System.out;
import static org.assertj.core.api.Assertions.assertThat;

public class PracticeTddTest {

    @Test
    void Integer_포함하지_않는다() {
        List<Integer> list = List.of(1, 2, 3);
        assertThat(list).doesNotContain(4, 5);
    }

    @Test
    void String_포함하지_않는다() {
        List<String> list = List.of("aa", "bb");
        assertThat(list).doesNotContain("aa", "bb");
    }

    @Test
    void LinkedList_순서() {
        LinkedList<String> list = new LinkedList<>(List.of("a", "b", "c", "d"));
        list.add(0, "0");
        out.println(list);
    }

    @Test
    void 불변성_테스트() {
        LinkedList<Line> lines = new LinkedList<Line>(List.of(
                new Line("1호선"),
                new Line("2호선"),
                new Line("3호선")));
        lines.add(1, new Line("00"));
        out.println(lines);
    }

    @Test
    void 불변성_테스트_도메인안에_도메인() {
        LinkedList<Section> sections = new LinkedList<>(
                List.of(
                        new Section("1호선", List.of(
                                new Station("가역"),
                                new Station("나역"),
                                new Station("다역")
                        ))));

        /*for (Section section : sections) {
            if (section.getLine().getName().equals("1호선")) {
                section.getStations().add(new Station("00역"));
            }
        }*/
        sections.get(0).getStations().add(new Station("00역"));
        out.println(sections);
    }

    @Test
    void 불변성_테스트_도메인안에_도메인2() {
        LinkedList<Station> stations = new LinkedList<>();
        stations.add(new Station("가역"));
        stations.add(new Station("나역"));
        stations.add(new Station("다역"));

        LinkedList<Section> sections = new LinkedList<>();
        sections.add(new Section("1호선", stations));

        sections.get(0).getStations().add(new Station("00역"));
        out.println(sections);
    }
}
