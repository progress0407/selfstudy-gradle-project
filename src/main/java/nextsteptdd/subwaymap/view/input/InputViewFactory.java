package nextsteptdd.subwaymap.view.input;

import nextsteptdd.subwaymap.view.constant.ViewType;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class InputViewFactory {

    private static Map<ViewType, Supplier<InputView>> viewConstructor;
    private static Map<ViewType, InputView> views; // 해당 뷰가 존재하는지

    private static InputViewMain inputViewMain;
    private static InputViewStation inputViewStation;
    private static InputViewLine inputViewLine;
    private static InputViewSection inputViewSection;

    static {
        initViewConstructor();
        initViewExistMap();
    }

    private static void initViewConstructor() {
        viewConstructor = new HashMap<>();
        viewConstructor.put(ViewType.MAIN, InputViewMain::new);
        viewConstructor.put(ViewType.STATION, InputViewStation::new);
        viewConstructor.put(ViewType.LINE, InputViewLine::new);
        viewConstructor.put(ViewType.SECTION, InputViewSection::new);
    }

    private static void initViewExistMap() {
        views = new HashMap<>();
        views.put(ViewType.MAIN, inputViewMain);
        views.put(ViewType.STATION, inputViewStation);
        views.put(ViewType.LINE, inputViewLine);
        views.put(ViewType.SECTION, inputViewSection);
    }

    /**
     * 싱글톤 관리를 위해 생성
     * @param viewType  생성할 뷰 타입
     * @return 생성된 뷰
     */

    public static InputView create(ViewType viewType) {
        InputView viewExist = views.get(viewType);
        if (viewExist == null) {
            InputView createdView = createView(viewType); // viewMap 생성하기
            views.replace(viewType, createdView); // 생성된 View를 전달하기
            return createdView;
        }
        return viewExist;
    }

    private static InputView createView(ViewType viewType) {
        return viewConstructor.get(viewType).get();
    }
}