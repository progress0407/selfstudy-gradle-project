package nextsteptdd.subwaymap.view.input;

import nextsteptdd.subwaymap.view.output.OutputView;
import nextsteptdd.subwaymap.view.output.OutputViewSection;

public class InputViewSection extends InputView {

    private static final String SHOW_DISPLAY =
            "## 구간 관리 화면" + LINE_SEPARATOR +
                    "1. 구간 등록" + LINE_SEPARATOR +
                    "2. 구간 삭제" + LINE_SEPARATOR +
                    "B. 돌아가기" + LINE_SEPARATOR + LINE_SEPARATOR +
                    "## 원하는 기능을 선택하세요.";

    public OutputView inputNumber() {
        showMenu(SHOW_DISPLAY);
        String input = scanner.nextLine();
        try {
            validateInput(input);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return new OutputViewSection(input);
    }

    @Override
    protected void validateInput(String input) {
        if (input.equalsIgnoreCase("B")) {
            return;
        }
        super.validateInput(input);
    }
}
