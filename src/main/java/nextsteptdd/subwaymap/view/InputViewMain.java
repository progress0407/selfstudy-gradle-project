package nextsteptdd.subwaymap.view;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Supplier;

public class InputViewMain extends InputView {

    private static final String SHOW_DISPLAY =
            "## 메인하면" +
                    System.lineSeparator() +
                    "1. 역 관리" +
                    System.lineSeparator() +
                    "2. 노선 관리" +
                    System.lineSeparator() +
                    "3. 구간 관리" +
                    System.lineSeparator() +
                    "4. 지하철 노선도 출력" +
                    System.lineSeparator() +
                    "Q. 종료";

    private static final Map<String, Supplier<InputView>> inputViewMap = new HashMap<>();

    static {
        inputViewMap.put("1", InputViewStation::new);
        inputViewMap.put("2", InputViewLine::new);
    }

    public String inputNumber() {
        showMenu(SHOW_DISPLAY);
        String input = scanner.nextLine();
        validateInput(input);
        InputView inputView = inputViewMap.get(input).get();
        return inputView.inputNumber();
    }

    @Override
    protected void validateInput(String input) {
        if (input.equalsIgnoreCase("Q")) {
            return;
        }
        super.validateInput(input);
    }
}
