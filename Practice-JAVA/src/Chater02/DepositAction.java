package Chater02;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class DepositAction extends AbstractActionHandler {

    public DepositAction(JLabel balanceLabel) {
        super(balanceLabel);
    }

    @Override
    protected void handleAction(ActionEvent e) {
        String input = JOptionPane.showInputDialog("입금할 금액을 입력하세요:");
        if (input != null && !input.isEmpty()) {
            int depositAmount = Integer.parseInt(input);
            BankProgram.balance += depositAmount;
            balanceLabel.setText("현재 잔액: " + BankProgram.balance + "원");
            JOptionPane.showMessageDialog(null, "입금이 완료되었습니다. 현재 잔액: " + BankProgram.balance + "원");
        }
    }
}
