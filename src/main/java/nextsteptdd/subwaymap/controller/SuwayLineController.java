package nextsteptdd.subwaymap.controller;

import nextsteptdd.subwaymap.view.constant.ViewType;
import nextsteptdd.subwaymap.view.input.InputView;
import nextsteptdd.subwaymap.view.input.InputViewFactory;
import nextsteptdd.subwaymap.view.input.InputViewMain;
import nextsteptdd.subwaymap.view.output.OutputView;

public class SuwayLineController {
    public void run() {
        String input = "";
        do {
            InputView inputView = InputViewFactory.create(ViewType.MAIN);
            OutputView outputView = inputView.inputNumber();
            input = outputView.printResult();
        } while(!input.equalsIgnoreCase("Q"));
    }
}
