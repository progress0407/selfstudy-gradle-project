package nextsteptdd.subwaymap.view.output;

import nextsteptdd.subwaymap.model.Section;
import nextsteptdd.subwaymap.repository.SectionRepository;

import java.util.List;

import static java.lang.System.out;

public class OutputViewSubwayLine extends OutputView {
    private static final String INFO_HEADER = "[INFO] ";
    private final String input;
    private static final String INFO_LINE_SEPARATOR = INFO_HEADER + "---";

    public OutputViewSubwayLine(String input) {
        this.input = input;
    }

    @Override
    public String printResult() {
        List<Section> sections = SectionRepository.getSections();
        sections.forEach(section -> {
            String lineName = section.getLine().getName();
            out.println(INFO_HEADER + lineName);
            out.println(INFO_LINE_SEPARATOR);
            section.getStations()
                    .forEach(station -> out.println(INFO_HEADER + station.getName()));
            out.println();
        });
        return input;
    }
}
