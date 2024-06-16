package Chater02;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class ExchangeAction implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        Map<String, Double> exchangeRates = new HashMap<>();
        exchangeRates.put("USD", 1.1);  // 예시: 1 달러 = 1.1 유로
        exchangeRates.put("EUR", 1.2);  // 예시: 1 유로 = 1.2 달러

        String input = JOptionPane.showInputDialog("환전할 금액을 입력하세요 (원):");
        if (input != null && !input.isEmpty()) {
            double amount = Double.parseDouble(input);
            String toCurrency = JOptionPane.showInputDialog("환전할 통화를 입력하세요 (예: USD, EUR):").toUpperCase();

            if (exchangeRates.containsKey(toCurrency)) {
                double convertedAmount = amount / exchangeRates.get(toCurrency);
                JOptionPane.showMessageDialog(null, "환전된 금액: " + convertedAmount + " " + toCurrency);
            } else {
                JOptionPane.showMessageDialog(null, "지원하지 않는 통화입니다.");
            }
        }
    }
}
