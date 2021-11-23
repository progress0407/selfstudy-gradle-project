package nextsteptdd.subwaymap.view;

public class InputViewLine extends InputView {

    private static final String SHOW_DISPLAY =
            "## 노선 관리 화면" + LINE_SEPARATOR +
                    "1. 노선 등록" + LINE_SEPARATOR +
                    "2. 노선 삭제" + LINE_SEPARATOR +
                    "3. 노선 조회" + LINE_SEPARATOR +
                    "B. 돌아가기";

    public OutputView inputNumber() {
        showMenu(SHOW_DISPLAY);
        String input = scanner.nextLine();
        try {
            validateInput(input);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return new OutputViewLine(input);
    }

    @Override
    protected void validateInput(String input) {
        if (input.equalsIgnoreCase("B")) {
            return;
        }
        super.validateInput(input);
    }
}
