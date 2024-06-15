package Chater01;

import java.util.Scanner;

public class JAVA04 {
    
    static void game01() {
        // 인출 업무 구현
        Scanner sc = new Scanner(System.in);
        double balance = 10000.0;  // 예시 잔액

        System.out.println("인출할 금액을 입력하세요:");
        double withdrawalAmount = sc.nextDouble();
        sc.nextLine();  // 버퍼 비우기

        if (withdrawalAmount > balance) {
            System.out.println("잔액이 부족합니다. 인출할 수 없습니다.");
        } else {
            balance -= withdrawalAmount;
            System.out.println("인출이 완료되었습니다. 남은 잔액: " + balance + "원");
        }
    }

    static void game02() {
        // 환전 업무 구현
        Scanner sc = new Scanner(System.in);
        double exchangeRate = 1.1;  // 예시 환율 (예: 1달러 = 1.1유로)

        System.out.println("환전할 금액을 입력하세요 (원):");
        double amount = sc.nextDouble();
        sc.nextLine();  // 버퍼 비우기

        System.out.println("환전할 통화를 선택하세요 (예: USD -> EUR):");
        String fromCurrency = sc.nextLine().toUpperCase();
        String toCurrency = sc.nextLine().toUpperCase();

        // 간단한 환율 변환 예시
        if (fromCurrency.equals("USD") && toCurrency.equals("EUR")) {
            double convertedAmount = amount * exchangeRate;
            System.out.println("환전된 금액: " + convertedAmount + " " + toCurrency);
        } else {
            System.out.println("지원하지 않는 통화입니다.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("업무를 선택하세요");
            System.out.println("인출 업무는 1, 환전 업무는 2, 종료는 9");
            int choice = sc.nextInt();
            sc.nextLine();  // 버퍼 비우기
            switch (choice) {
                case 1:
                    game01();
                    break;
                case 2:
                    game02();
                    break;
                case 9:
                    System.out.println("업무를 종료합니다.");
                    System.exit(0);
                default:
                    System.out.println("잘못된 입력입니다. 다시 시도하세요.");
            }
        }
    }
}
