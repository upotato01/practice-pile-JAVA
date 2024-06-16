package Chater02;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class WithdrawalAction extends AbstractActionHandler {

    public WithdrawalAction(JLabel balanceLabel) {
        super(balanceLabel);
    }

    @Override
    protected void handleAction(ActionEvent e) {
        String input = JOptionPane.showInputDialog("인출할 금액을 입력하세요 (만원, 오만원 단위로 입력):");
        if (input != null && !input.isEmpty()) {
            int withdrawalAmount = Integer.parseInt(input);
            if (withdrawalAmount % 10000 != 0 || (withdrawalAmount % 50000 != 0 && withdrawalAmount % 10000 == 0)) {
                JOptionPane.showMessageDialog(null, "만원, 오만원 단위로만 인출할 수 있습니다.");
            } else if (withdrawalAmount > BankProgram.balance) {
                JOptionPane.showMessageDialog(null, "잔액이 부족합니다. 인출할 수 없습니다.");
            } else {
                String[] options = {"만원권", "오만원권"};
                int noteType = JOptionPane.showOptionDialog(null, "인출할 금액의 종류를 선택하세요:",
                        "인출", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

                if (noteType == 1) { // 오만원권
                    int maxNotes = withdrawalAmount / 50000;
                    String noteInput = JOptionPane.showInputDialog("인출할 오만원권 개수를 입력하세요 (최대 " + maxNotes + "개):");
                    if (noteInput != null && !noteInput.isEmpty()) {
                        int numNotes = Integer.parseInt(noteInput);
                        int totalAmount = numNotes * 50000;
                        if (totalAmount > BankProgram.balance) {
                            JOptionPane.showMessageDialog(null, "잔액이 부족합니다.");
                        } else {
                            BankProgram.balance -= totalAmount;
                            balanceLabel.setText("현재 잔액: " + BankProgram.balance + "원");
                            JOptionPane.showMessageDialog(null, "인출이 완료되었습니다. 남은 잔액: " + BankProgram.balance + "원");
                        }
                    }
                } else if (noteType == 0) { // 만원권
                    BankProgram.balance -= withdrawalAmount;
                    balanceLabel.setText("현재 잔액: " + BankProgram.balance + "원");
                    JOptionPane.showMessageDialog(null, "인출이 완료되었습니다. 남은 잔액: " + BankProgram.balance + "원");
                } else {
                    JOptionPane.showMessageDialog(null, "잘못된 입력입니다. 인출할 금액의 종류를 다시 선택하세요.");
                }
            }
        }
    }
}
