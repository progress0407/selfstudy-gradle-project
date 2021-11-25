package nextsteptdd.subwaymap.view.output;

import nextsteptdd.subwaymap.model.Line;
import nextsteptdd.subwaymap.repository.LineRepository;
import nextsteptdd.subwaymap.repository.SectionRepository;
import nextsteptdd.subwaymap.util.Voider;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.System.out;

public class OutputViewSection extends OutputView {

    private static final String INPUT_ADD_LINE_NAME = "## 노선을 입력하세요.";
    private static final String INPUT_ADD_STATION_NAME = "## 역이름을 입력하세요.";
    private static final String INFO_ADD_SECTION = "## 역이름을 입력하세요.";
    private static final String INPUT_STATION_ORDER = "## 순서를 입력하세요.";
    private static final String INPUT_DELETE_LINE_NAME = "## 삭제할 구간의 노선을 입력하세요.";
    private static final String INPUT_DELETE_STATION_NAME = "## 삭제할 구간의 역을 입력하세요.";
    private static final String INFO_DELETE_SECTION = "[INFO] 구간이 삭제되었습니다.";

    String input;

    public OutputViewSection(String input) {
        this.input = input;
    }

    private static final Map<String, Voider> behaviorMap = new HashMap<>();

    static {
        behaviorMap.put("1", OutputViewSection::addSection);
//        behaviorMap.put("2", OutputViewSection::deleteSection);
        behaviorMap.put("B", OutputViewSection::returnMainMenu);
    }

    @Override
    public String printResult() {
        behaviorMap.get(input).call();
        return input;
    }

    private static void addSection() {
        out.println(INPUT_ADD_LINE_NAME);
        String lineName = scanner.nextLine();
        out.println(INPUT_ADD_STATION_NAME);
        String stationName = scanner.nextLine();
        out.println(INPUT_STATION_ORDER);
        int stationOrder = scanner.nextInt();
        try {
            SectionRepository.addSection(lineName, stationName, stationOrder);
            out.println(INFO_ADD_SECTION);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

/*    private static void deleteSection() {
        out.println(INPUT_DELETE_LINE_NAME);
        String lineName = scanner.nextLine();
        boolean deleteLine = LineRepository.deleteLineByName(lineName);
        if (deleteLine) {
            out.println(INFO_DELETE_LINE);
            return;
        }
        out.println(ERROR_DELETE_LINE);
    }*/

    private static void returnMainMenu() {}
}
