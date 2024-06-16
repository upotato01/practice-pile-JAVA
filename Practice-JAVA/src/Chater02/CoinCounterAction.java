package Chater02;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CoinCounterAction implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        int tenWonCount = Integer.parseInt(JOptionPane.showInputDialog("10원 동전 개수:"));
        int fiftyWonCount = Integer.parseInt(JOptionPane.showInputDialog("50원 동전 개수:"));
        int hundredWonCount = Integer.parseInt(JOptionPane.showInputDialog("100원 동전 개수:"));
        int fiveHundredWonCount = Integer.parseInt(JOptionPane.showInputDialog("500원 동전 개수:"));

        int totalCoinsValue = tenWonCount * 10 + fiftyWonCount * 50 + hundredWonCount * 100 + fiveHundredWonCount * 500;
        JOptionPane.showMessageDialog(null, "동전 총액: " + totalCoinsValue + "원");
    }
}
