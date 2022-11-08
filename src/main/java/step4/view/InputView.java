package step4.view;

import step4.model.Lottos;

import java.util.Scanner;

public class InputView {

    private static final String LOTTO_NUMBER_STATUS = "[%s]";

    private Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public int readyBuyingLotto() {
        System.out.println("구입금액을 입력해 주세요.");
        return this.scanner.nextInt();
    }

    public int readyBonus() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return this.scanner.nextInt();
    }

    public void printBoughtLottoCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public String readyWinningLotto() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return this.scanner.next() + this.scanner.nextLine();
    }

    public void printLottos(Lottos lottos) {
        lottos.print(System.out::println);
    }
}