package chapter02;

public class BankProgram {
    static int balance = 0;  // 예시 잔액

    public static void main(String[] args) {
        BankFrame frame = new BankFrame();
        frame.setVisible(true);
    }
}
