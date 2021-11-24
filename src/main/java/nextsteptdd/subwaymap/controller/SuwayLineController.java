package nextsteptdd.subwaymap.controller;

import nextsteptdd.subwaymap.view.input.InputViewMain;
import nextsteptdd.subwaymap.view.output.OutputView;

public class SuwayLineController {
    public void run() {
        String input = "";
        do {
            OutputView outputView = new InputViewMain().inputNumber();
            input = outputView.printResult();
        } while(!input.equalsIgnoreCase("Q") || input.equalsIgnoreCase("B"));
    }
}
