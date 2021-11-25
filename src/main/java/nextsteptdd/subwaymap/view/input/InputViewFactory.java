package nextsteptdd.subwaymap.view.input;

import nextsteptdd.subwaymap.util.Voider;
import nextsteptdd.subwaymap.view.constant.ViewType;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class InputViewFactory {

    private static Map<ViewType, Supplier<InputView>> viewMap;
    private static Map<ViewType, InputView> viewExistMap; // 해당 뷰가 존재하는지

    private static InputViewMain inputViewMain;
    private static InputViewStation inputViewStation;
    private static InputViewLine inputViewLine;
    private static InputViewSection inputViewSection;

    static {
        initViewMap();
        initViewExistMap();
    }

    private static void initViewMap() {
        viewMap = new HashMap<>();
        viewMap.put(ViewType.MAIN, InputViewMain::new);
        viewMap.put(ViewType.STATION, InputViewStation::new);
        viewMap.put(ViewType.LINE, InputViewLine::new);
        viewMap.put(ViewType.SECTION, InputViewSection::new);
    }

    private static void initViewExistMap() {
        viewExistMap = new HashMap<>();
        viewExistMap.put(ViewType.MAIN, inputViewMain);
        viewExistMap.put(ViewType.STATION, inputViewStation);
        viewExistMap.put(ViewType.LINE, inputViewLine);
        viewExistMap.put(ViewType.SECTION, inputViewSection);
    }

    /**
     * 싱글톤 관리를 위해 생성
     * @param viewType  생성할 뷰 타입
     * @return
     */
    public static InputView create(ViewType viewType) {
        InputView viewExist = viewExistMap.get(viewType);
        if (viewExist == null) {
            InputView createdView = createView(viewType); // viewMap 생성하기
            viewExistMap.replace(viewType, createdView); // 생성된 View를 전달하기
        }
        return viewExistMap.get(viewType);
    }

    private static InputView createView(ViewType viewType) {
        return viewMap.get(viewType).get();
    }
}