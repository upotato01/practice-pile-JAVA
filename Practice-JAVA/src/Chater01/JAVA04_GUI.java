package Chater01;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class JAVA04_GUI {
    static int balance = 0;  // 예시 잔액

    public static void main(String[] args) {
        // JFrame 설정
        JFrame frame = new JFrame("은행 프로그램");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);
        frame.setLayout(new BorderLayout());

        // 타이틀 라벨 설정
        JLabel titleLabel = new JLabel("환영합니다!", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 24));
        titleLabel.setForeground(new Color(0, 102, 204));
        frame.add(titleLabel, BorderLayout.NORTH);

        // 중앙 패널 설정
        JPanel centerPanel = new JPanel(new GridLayout(6, 1, 10, 10));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        frame.add(centerPanel, BorderLayout.CENTER);

        // 잔액 라벨 설정
        JLabel balanceLabel = new JLabel("현재 잔액: " + balance + "원", SwingConstants.CENTER);
        balanceLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        centerPanel.add(balanceLabel);

        // 버튼 설정
        JButton depositButton = new JButton("입금");
        JButton withdrawalButton = new JButton("인출");
        JButton exchangeButton = new JButton("환전");
        JButton coinCounterButton = new JButton("동전 계수기");
        JButton exitButton = new JButton("종료");

        // 버튼 폰트와 색상 설정
        Font buttonFont = new Font("Serif", Font.PLAIN, 18);
        depositButton.setFont(buttonFont);
        withdrawalButton.setFont(buttonFont);
        exchangeButton.setFont(buttonFont);
        coinCounterButton.setFont(buttonFont);
        exitButton.setFont(buttonFont);

        depositButton.setBackground(new Color(153, 204, 255));
        withdrawalButton.setBackground(new Color(153, 204, 255));
        exchangeButton.setBackground(new Color(153, 204, 255));
        coinCounterButton.setBackground(new Color(153, 204, 255));
        exitButton.setBackground(new Color(255, 153, 153));

        centerPanel.add(depositButton);
        centerPanel.add(withdrawalButton);
        centerPanel.add(exchangeButton);
        centerPanel.add(coinCounterButton);
        centerPanel.add(exitButton);

        // 이벤트 리스너 설정
        depositButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog("입금할 금액을 입력하세요:");
                if (input != null && !input.isEmpty()) {
                    int depositAmount = Integer.parseInt(input);
                    balance += depositAmount;
                    balanceLabel.setText("현재 잔액: " + balance + "원");
                    JOptionPane.showMessageDialog(frame, "입금이 완료되었습니다. 현재 잔액: " + balance + "원");
                }
            }
        });

        withdrawalButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog("인출할 금액을 입력하세요 (만원, 오만원 단위로 입력):");
                if (input != null && !input.isEmpty()) {
                    int withdrawalAmount = Integer.parseInt(input);
                    if (withdrawalAmount % 10000 != 0 || (withdrawalAmount % 50000 != 0 && withdrawalAmount % 10000 == 0)) {
                        JOptionPane.showMessageDialog(frame, "만원, 오만원 단위로만 인출할 수 있습니다.");
                    } else if (withdrawalAmount > balance) {
                        JOptionPane.showMessageDialog(frame, "잔액이 부족합니다. 인출할 수 없습니다.");
                    } else {
                        String[] options = {"만원권", "오만원권"};
                        int noteType = JOptionPane.showOptionDialog(frame, "인출할 금액의 종류를 선택하세요:",
                                "인출", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

                        if (noteType == 1) { // 오만원권
                            int maxNotes = withdrawalAmount / 50000;
                            String noteInput = JOptionPane.showInputDialog("인출할 오만원권 개수를 입력하세요 (최대 " + maxNotes + "개):");
                            if (noteInput != null && !noteInput.isEmpty()) {
                                int numNotes = Integer.parseInt(noteInput);
                                int totalAmount = numNotes * 50000;
                                if (totalAmount > balance) {
                                    JOptionPane.showMessageDialog(frame, "잔액이 부족합니다.");
                                } else {
                                    balance -= totalAmount;
                                    balanceLabel.setText("현재 잔액: " + balance + "원");
                                    JOptionPane.showMessageDialog(frame, "인출이 완료되었습니다. 남은 잔액: " + balance + "원");
                                }
                            }
                        } else if (noteType == 0) { // 만원권
                            balance -= withdrawalAmount;
                            balanceLabel.setText("현재 잔액: " + balance + "원");
                            JOptionPane.showMessageDialog(frame, "인출이 완료되었습니다. 남은 잔액: " + balance + "원");
                        } else {
                            JOptionPane.showMessageDialog(frame, "잘못된 입력입니다. 인출할 금액의 종류를 다시 선택하세요.");
                        }
                    }
                }
            }
        });

        exchangeButton.addActionListener(new ActionListener() {
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
                        JOptionPane.showMessageDialog(frame, "환전된 금액: " + convertedAmount + " " + toCurrency);
                    } else {
                        JOptionPane.showMessageDialog(frame, "지원하지 않는 통화입니다.");
                    }
                }
            }
        });

        coinCounterButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int tenWonCount = Integer.parseInt(JOptionPane.showInputDialog("10원 동전 개수:"));
                int fiftyWonCount = Integer.parseInt(JOptionPane.showInputDialog("50원 동전 개수:"));
                int hundredWonCount = Integer.parseInt(JOptionPane.showInputDialog("100원 동전 개수:"));
                int fiveHundredWonCount = Integer.parseInt(JOptionPane.showInputDialog("500원 동전 개수:"));

                int totalCoinsValue = tenWonCount * 10 + fiftyWonCount * 50 + hundredWonCount * 100 + fiveHundredWonCount * 500;
                JOptionPane.showMessageDialog(frame, "동전 총액: " + totalCoinsValue + "원");
            }
        });

        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        frame.setVisible(true);
    }
}
