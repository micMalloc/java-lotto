package kr.heesu.lotto.view;

import kr.heesu.lotto.domain.LottoStatistics;
import kr.heesu.lotto.domain.ManualCount;
import kr.heesu.lotto.domain.PurchaseAmount;

import java.util.ArrayList;
import java.util.List;

public class ViewResolver {
    private final InputView inputView;
    private final ResultView resultView;

    private ViewResolver(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public static ViewResolver of() {
        InputView inputView = InputView.getInstance();
        ResultView resultView = ResultView.getInstance();

        return new ViewResolver(inputView, resultView);
    }

    public String getPurchaseAmount() {
        System.out.println(ViewMessage.INPUT_FOR_PURCHASE_AMOUNT.getMessage());
        return this.inputView.read();
    }

    public String getManualAmount() {
        System.out.println(ViewMessage.INPUT_FOR_MANUAL_AMOUNT.getMessage());
        return this.inputView.read();
    }

    public String getWinningLotto() {
        System.out.println(ViewMessage.INPUT_FOR_WINNING_NUMBERS.getMessage());
        return this.inputView.read();
    }

    public List<String> getInputForManualLottos(ManualCount count) {
        System.out.println(ViewMessage.INPUT_FOR_MANUAL_LOTTO.getMessage());
        List<String> inputs = new ArrayList<>();

        while (inputs.size() < count.getSize()) {
            inputs.add(inputView.read());
        }
        return inputs;
    }

    public String getInputForManualStringLottos(ManualCount count) {
        System.out.println(ViewMessage.INPUT_FOR_MANUAL_LOTTO.getMessage());
        List<String> inputs = new ArrayList<>();

        while (inputs.size() < count.getSize()) {
            inputs.add(inputView.read());
        }
        return String.join("\n", inputs);
    }

    public String getBonusNumbers() {
        System.out.println(ViewMessage.INPUT_FOR_BONUS_NUMBER.getMessage());
        return this.inputView.read();
    }

    public void printLottoStatistics(LottoStatistics result) {
        System.out.println(ViewMessage.OUTPUT_FOR_LOTTO_STATISTICS.getMessage());
        System.out.println(ViewMessage.OUTPUT_FOR_LINE.getMessage());

        resultView.printLottoStatistics(result);
    }

    public void printMultipleLotto(String multipleLotto) {
        resultView.printMultipleLotto(multipleLotto);
    }

    public void printPurchaseAmount(PurchaseAmount amount, ManualCount count) {
        resultView.printPurchaseAmount(amount, count);
    }
}