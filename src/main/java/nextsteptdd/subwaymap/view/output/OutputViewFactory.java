package nextsteptdd.subwaymap.view.output;

import nextsteptdd.subwaymap.view.constant.ViewType;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

public class OutputViewFactory {

    private static Map<ViewType, Function<String, OutputView>> viewConstructor;
    private static Map<ViewType, OutputView> views;

    private static OutputViewStation outputViewStation;
    private static OutputViewLine outputViewLine;
    private static OutputViewSection outputViewSection;
    private static OutputViewSubwayLine outputViewSubwayLine;

    static {
        initViewConstructor();
        initViews();
    }

    private static void initViewConstructor() {
        viewConstructor = new HashMap<>();
        viewConstructor.put(ViewType.STATION, OutputViewStation::new);
        viewConstructor.put(ViewType.LINE, OutputViewLine::new);
        viewConstructor.put(ViewType.SECTION, OutputViewSection::new);
        viewConstructor.put(ViewType.SUBWAY_LINE, OutputViewSubwayLine::new);
    }

    private static void initViews() {
        views = new HashMap<>();
        views.put(ViewType.STATION, outputViewStation);
        views.put(ViewType.LINE, outputViewLine);
        views.put(ViewType.SECTION, outputViewSection);
        views.put(ViewType.SUBWAY_LINE, outputViewSubwayLine);
    }

    public static OutputView create(ViewType viewType, String input) {
        OutputView viewExist = views.get(viewType);
        if (viewExist == null) {
            OutputView createdView = createView(viewType, input);
            views.replace(viewType, createdView);
            return createdView;
        }
        return viewExist;
    }

    private static OutputView createView(ViewType viewType, String input) {
        return viewConstructor.get(viewType).apply(input);
    }
}
