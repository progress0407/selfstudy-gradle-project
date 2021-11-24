package nextsteptdd.subwaymap.repository;

import nextsteptdd.subwaymap.model.Line;
import nextsteptdd.subwaymap.model.Section;
import nextsteptdd.subwaymap.model.Station;

import java.util.*;

import static java.lang.System.out;

/**
 * 구간을 다루는 Repository입니다
 * LineRepostory와 StationRepository를 의존합니다
 */
public class SectionRepository {

    private static final String ERROR_NOT_FOUND_LINE = "해당 역을 찾을 수 없습니다";
    private static ArrayList<Section> sections;

    static {
        initData();
    }

    public static void initData() {
        sections = new ArrayList<>(Arrays.asList(
                new Section("2호선",
                        Arrays.asList(
                            new Station("교대역"),
                            new Station("강남역"),
                            new Station("역삼역")
                        )),

                new Section("3호선",
                        Arrays.asList(
                            new Station("교대역"),
                            new Station("남부터미널역"),
                            new Station("양재역"),
                            new Station("매봉역")
                )),

                new Section("신분당선",
                        Arrays.asList(
                            new Station("강남역"),
                            new Station("양재역"),
                            new Station("양재시민의숲역")
                ))
        ));
    }

    public static List<Section> getSections() {
        return Collections.unmodifiableList(sections);
    }

    public static Section findSectionByLineName(String lineName) {
        return sections.stream()
                .filter(section -> section.getLine().getName().equals(lineName))
                .findAny()
                .orElseGet(() -> {
                    out.println(ERROR_NOT_FOUND_LINE);
                    return null;
                });
    }

    /**
     * 이미 존재하는 구간에 역을 삽입한다
     * @param lineName     노선 이름
     * @param stationName  역 이름
     * @param stationOrder 등록될 역의 순서
     */
    public static void addSection(String lineName, String stationName, int stationOrder) {
        Line findLine = LineRepository.findLineByName(lineName);
        if (findLine != null) {
            StationRepository.addStation(new Station(stationName));
            Section findSection = findSectionByLineName(lineName);
            findSection.getStations().add(stationOrder, new Station(stationName));
        }
    }

    /**
     * 새로운 구간을 넣는다
     * @param lineName                노선 이름
     * @param ascendingStationName  상행 종점역
     * @param descendingStationName 하행 종점역
     */
    public static void addSection(String lineName, String ascendingStationName, String descendingStationName) {
        Section section = new Section(lineName, ascendingStationName, descendingStationName);
        sections.add(section);
    }


}
