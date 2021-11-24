package practicetdd;

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
}
