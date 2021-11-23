package nextsteptdd.subwaymap.view;

public class InputViewStation extends InputView {

    private static final String SHOW_DISPLAY =
            "## 메인하면" +
                    System.lineSeparator() +
                    "1. 역 등록" +
                    System.lineSeparator() +
                    "2. 역 삭제" +
                    System.lineSeparator() +
                    "3. 역 조회" +
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
