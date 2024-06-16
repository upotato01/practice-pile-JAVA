package Chater02;

import javax.swing.*;
import java.awt.*;

public class BankFrame extends JFrame {
    private JLabel balanceLabel;

    public BankFrame() {
        setTitle("은행 프로그램");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLayout(new BorderLayout());

        // 타이틀 라벨 설정
        JLabel titleLabel = new JLabel("환영합니다!", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 24));
        titleLabel.setForeground(new Color(0, 102, 204));
        add(titleLabel, BorderLayout.NORTH);

        // 중앙 패널 설정
        JPanel centerPanel = new JPanel(new GridLayout(6, 1, 10, 10));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(centerPanel, BorderLayout.CENTER);

        // 잔액 라벨 설정
        balanceLabel = new JLabel("현재 잔액: " + BankProgram.balance + "원", SwingConstants.CENTER);
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
        depositButton.addActionListener(new DepositAction(balanceLabel));
        withdrawalButton.addActionListener(new WithdrawalAction(balanceLabel));
        exchangeButton.addActionListener(new ExchangeAction());
        coinCounterButton.addActionListener(new CoinCounterAction());
        exitButton.addActionListener(e -> System.exit(0));
    }
}
