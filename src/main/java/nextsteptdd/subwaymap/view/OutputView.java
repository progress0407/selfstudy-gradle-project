package nextsteptdd.subwaymap.view;

import java.util.Scanner;

public abstract class OutputView {

    protected static final String LINE_SEPARATOR = System.lineSeparator();
    protected static Scanner scanner = new Scanner(System.in);

    public abstract String printResult();
}
