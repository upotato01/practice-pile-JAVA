package Chater02;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class AbstractActionHandler implements ActionListener {
    protected JLabel balanceLabel;

    public AbstractActionHandler(JLabel balanceLabel) {
        this.balanceLabel = balanceLabel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        handleAction(e);
    }

    protected abstract void handleAction(ActionEvent e);
}
