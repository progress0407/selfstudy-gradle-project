package nextsteptdd.subwaymap.controller;

import nextsteptdd.subwaymap.view.InputViewMain;

public class SuwayLineController {
    public void run() {
        String input = "";
        do {
            input = new InputViewMain().inputNumber();
        } while(!input.equalsIgnoreCase("Q") || input.equalsIgnoreCase("B"));
    }
}
