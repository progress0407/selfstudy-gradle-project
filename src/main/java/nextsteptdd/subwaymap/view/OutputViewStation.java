package nextsteptdd.subwaymap.view;

import nextsteptdd.subwaymap.domain.Station;
import nextsteptdd.subwaymap.domain.StationRepository;
import nextsteptdd.subwaymap.util.Voider;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.System.out;

public class OutputViewStation extends OutputView {

    private static final String INPUT_ADD_STATION_NAME = "## 등록할 역 이름을 입력하세요.";
    private static final String INFO_ADD_STATION = "[INFO] 지하철 역이 등록되었습니다." + LINE_SEPARATOR;
    private static final String INPUT_DELETE_STATION_NAME = "## 삭제할 역 이름을 입력하세요.";
    private static final String INFO_DELETE_STATION = "[INFO] 지하철 역이 삭제되었습니다." + LINE_SEPARATOR;
    private static final String ERROR_DELETE_STATION = "[ERROR] 삭제할 지하철이 존재하지 않습니다." + LINE_SEPARATOR;
    private static final String PRINT_LIST_STATION = "## 역 목록";

    String input;

    public OutputViewStation(String input) {
        this.input = input;
    }

    private static final Map<String, Voider> behaviorMap = new HashMap<>();

    static {
        behaviorMap.put("1", OutputViewStation::addStation);
        behaviorMap.put("2", OutputViewStation::deleteStation);
        behaviorMap.put("3", OutputViewStation::stations);
    }

    @Override
    public String printResult() {
        behaviorMap.get(input).call();
        return input;
    }

    private static void stations() {
        out.println(PRINT_LIST_STATION);
        List<Station> stations = StationRepository.stations();
        stations.forEach(e -> out.println("[INFO] " + e.getName()));
        out.println();
    }

    private static void addStation() {
        out.println(INPUT_ADD_STATION_NAME);
        String stationName = scanner.nextLine();
        StationRepository.addStation(new Station(stationName));
        out.println(INFO_ADD_STATION);
    }

    private static void deleteStation() {
        out.println(INPUT_DELETE_STATION_NAME);
        String stationName = scanner.nextLine();
        boolean deleteStation = StationRepository.deleteStation(stationName);
        if (deleteStation) {
            out.println(INFO_DELETE_STATION);
            return;
        }
        out.println(ERROR_DELETE_STATION);
    }
}
