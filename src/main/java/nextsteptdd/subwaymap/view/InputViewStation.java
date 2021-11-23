package nextsteptdd.subwaymap.view;

import nextsteptdd.subwaymap.domain.Station;
import nextsteptdd.subwaymap.domain.StationRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class InputViewStation extends InputView {

    private static final String INPUT_ADD_STATION_NAME = "## 등록할 역 이름을 입력하세요.";
    private static final String INFO_ADD_STATION = "[INFO] 지하철 역이 등록되었습니다." + LINE_SEPARATOR;
    private static final String INPUT_DELETE_STATION_NAME = "## 삭제할 역 이름을 입력하세요.";
    private static final String INFO_DELETE_STATION = "[INFO] 지하철 역이 삭제되었습니다." + LINE_SEPARATOR;
    private static final String ERROR_DELETE_STATION = "[ERROR] 삭제할 지하철이 존재하지 않습니다." + LINE_SEPARATOR;
    private static final String INPUT_LIST_STATION_NAME = "## 역 목록";

    private static final String SHOW_DISPLAY =
            "## 역 관리 화면" +
                    LINE_SEPARATOR +
                    "1. 역 등록" +
                    LINE_SEPARATOR +
                    "2. 역 삭제" +
                    LINE_SEPARATOR +
                    "3. 역 조회" +
                    LINE_SEPARATOR +
                    "B. 돌아가기" +
                    LINE_SEPARATOR +
                    LINE_SEPARATOR +
                    "## 원하는 기능을 선택하세요.";

    private static final Map<String, Supplier<Void>> inputViewMap = new HashMap<>();

    static {
        inputViewMap.put("1", InputViewStation::addStation);
        inputViewMap.put("2", InputViewStation::deleteStation);
        inputViewMap.put("3", InputViewStation::stations);
    }

    public String inputNumber() {
        showMenu(SHOW_DISPLAY);
        String input = scanner.nextLine();
        validateInput(input);
        inputViewMap.get(input).get();
        // 정상 처리시 돌아가기
        return "B";
    }

    private static Void stations() {
        System.out.println(INPUT_LIST_STATION_NAME);
        List<Station> stations = StationRepository.stations();
        stations.forEach(e -> System.out.println("[INFO] " + e.getName()));
        System.out.println();
        return null;
    }

    private static Void deleteStation() {
        System.out.println(INPUT_DELETE_STATION_NAME);
        String stationName = scanner.nextLine();
        boolean deleteStation = StationRepository.deleteStation(stationName);
        if (deleteStation) {
            System.out.println(INFO_DELETE_STATION);
            return null;
        }
        System.out.println(ERROR_DELETE_STATION);
        return null;
    }

    private static Void addStation() {
        System.out.println(INPUT_ADD_STATION_NAME);
        String stationName = scanner.nextLine();
        StationRepository.addStation(new Station(stationName));
        System.out.println(INFO_ADD_STATION);
        return null;
    }


    @Override
    protected void validateInput(String input) {
        if (input.equalsIgnoreCase("B")) {
            return;
        }
        super.validateInput(input);
    }
}
