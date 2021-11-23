package nextsteptdd.subwaymap.view;

public class InputViewLine extends InputView {

    private static final String SHOW_DISPLAY =
            "## 메인하면" +
                    System.lineSeparator() +
                    "1. 노선 등록" +
                    System.lineSeparator() +
                    "2. 노선 삭제" +
                    System.lineSeparator() +
                    "3. 노선 조회" +
                    System.lineSeparator() +
                    "B. 돌아가기";

    public String inputNumber() {
        showMenu(SHOW_DISPLAY);
        String input = scanner.nextLine();
        validateInput(input);
        return input;
    }

    @Override
    protected void validateInput(String input) {
        if (input.equalsIgnoreCase("B")) {
            return;
        }
        super.validateInput(input);
    }
}
