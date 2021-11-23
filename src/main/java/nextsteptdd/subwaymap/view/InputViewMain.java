package nextsteptdd.subwaymap.view;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Supplier;

public class InputViewMain extends InputView {

    private static final String SHOW_DISPLAY =
            "## 메인화면" + LINE_SEPARATOR +
                    "1. 역 관리" + LINE_SEPARATOR +
                    "2. 노선 관리" + LINE_SEPARATOR +
                    "3. 구간 관리" + LINE_SEPARATOR +
                    "4. 지하철 노선도 출력" + LINE_SEPARATOR +
                    "Q. 종료" + LINE_SEPARATOR + LINE_SEPARATOR +
                    "## 원하는 기능을 선택하세요.";

    private static final Map<String, Supplier<InputView>> inputViewMap = new HashMap<>();

    static {
        inputViewMap.put("1", InputViewStation::new);
        inputViewMap.put("2", InputViewLine::new);
    }

    public String inputNumber() {
        showMenu(SHOW_DISPLAY);
        String input = scanner.nextLine();
        validateInput(input);
        Supplier<InputView> inputViewSupplier = inputViewMap.get(input);
        return inputViewSupplier.get().inputNumber();
    }

    @Override
    protected void validateInput(String input) {
        if (input.equalsIgnoreCase("Q")) {
            return;
        }
        super.validateInput(input);
    }
}
