package nextsteptdd.subwaymap.view.input;

import nextsteptdd.subwaymap.view.constant.ViewType;
import nextsteptdd.subwaymap.view.output.OutputView;
import nextsteptdd.subwaymap.view.output.OutputViewFactory;
import nextsteptdd.subwaymap.view.output.OutputViewSection;
import nextsteptdd.subwaymap.view.output.OutputViewSubwayLine;

public class InputViewSubwayLine extends InputView {

    private static final String SHOW_DISPLAY = "## 지하철 노선도";

    @Override
    public OutputView inputNumber() {
        showMenu(SHOW_DISPLAY);
        return OutputViewFactory.create(ViewType.SUBWAY_LINE, "B");
    }

    @Override
    protected void validateInput(String input) {
        return;
    }
}
