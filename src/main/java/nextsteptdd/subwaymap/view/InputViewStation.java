package nextsteptdd.subwaymap.view;

public class InputViewStation extends InputView {

    private static final String SHOW_DISPLAY =
            "## 역 관리 화면" + LINE_SEPARATOR +
                    "1. 역 등록" + LINE_SEPARATOR +
                    "2. 역 삭제" + LINE_SEPARATOR +
                    "3. 역 조회" + LINE_SEPARATOR +
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
        // 정상 처리시 돌아가기
        return new OutputViewStation(input);
    }

    @Override
    protected void validateInput(String input) {
        if (input.equalsIgnoreCase("B")) {
            return;
        }
        super.validateInput(input);
    }
}
