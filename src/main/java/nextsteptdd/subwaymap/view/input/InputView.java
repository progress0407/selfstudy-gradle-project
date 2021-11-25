package nextsteptdd.subwaymap.view.input;

import nextsteptdd.subwaymap.view.output.OutputView;

import java.util.Scanner;

import static java.lang.System.out;

public abstract class InputView {

    protected static final String LINE_SEPARATOR = System.lineSeparator();
    private static final String ERROR_OUT_OF_MENU = "선택할 수 없는 기능입니다.";
    protected static Scanner scanner = new Scanner(System.in);

    protected static void showMenu(final String SHOW_DISPLAY) {
        out.println(SHOW_DISPLAY);
    }

    public abstract OutputView inputNumber();

    protected void validateInput(String input) {
        int anInt = 0;
        try {
            anInt = Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException(ERROR_OUT_OF_MENU);
        }
        if (anInt < 1 || anInt > 4) {
            throw new IllegalArgumentException(ERROR_OUT_OF_MENU);
        }
    }
}
