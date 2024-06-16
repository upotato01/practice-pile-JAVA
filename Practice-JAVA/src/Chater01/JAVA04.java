package Chater01;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class JAVA04 {

    static int balance = 0;  // 예시 잔액

    static void deposit() {
        Scanner sc = new Scanner(System.in);
        System.out.println("입금할 금액을 입력하세요:");
        int depositAmount = sc.nextInt();
        sc.nextLine();  // 버퍼 비우기

        balance += depositAmount;
        System.out.println("입금이 완료되었습니다. 현재 잔액: " + balance + "원");
    }

    static void withdrawal() throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("인출할 금액을 입력하세요:");
        int withdrawalAmount = sc.nextInt();
        sc.nextLine();  // 버퍼 비우기

        if (withdrawalAmount > balance) {
            System.out.println("잔액이 부족합니다. 인출할 수 없습니다.");
        } else {
            System.out.println("인출할 금액의 종류를 선택하세요 (1: 만원권, 2: 오만원권):");
            int noteType = sc.nextInt();
            sc.nextLine();  // 버퍼 비우기

            if (noteType == 2) {
                System.out.println("인출할 오만원권 개수를 선택해주세요:");
                int numNotes = sc.nextInt();
                int totalAmount = numNotes * 50000;

                if (totalAmount > balance) {
                    System.out.println("잔액이 부족합니다.");
                    System.out.println("최대 " + (balance / 50000) + "개까지 인출 가능합니다.");
                } else {
                    balance -= totalAmount;
                    System.out.print("인출 중입니다.");
                    Thread.sleep(2000);
                    System.out.println("\n인출이 완료되었습니다. 남은 잔액: " + balance + "원");
                }
            } else if (noteType == 1) {
                if (withdrawalAmount % 10000 != 0) {
                    System.out.println("만원권 단위로 인출해야 합니다.");
                } else {
                    balance -= withdrawalAmount;
                    System.out.println("만원권 " + (withdrawalAmount / 10000) + "개가 인출되었습니다.");
                    System.out.println("인출이 완료되었습니다. 남은 잔액: " + balance + "원");
                }
            } else {
                System.out.println("잘못된 입력입니다. 인출할 금액의 종류를 다시 선택하세요.");
            }
        }
    }

    static void exchange() {
        Scanner sc = new Scanner(System.in);

        // 환율 맵 설정
        Map<String, Double> exchangeRates = new HashMap<>();
        exchangeRates.put("USD", 1.1);  // 예시: 1 달러 = 1.1 유로
        exchangeRates.put("EUR", 1.2);  // 예시: 1 유로 = 1.2 달러

        System.out.println("환전할 금액을 입력하세요 (원):");
        double amount = sc.nextDouble();
        sc.nextLine();  // 버퍼 비우기

        System.out.println("환전할 통화를 입력하세요 (예: USD, EUR):");
        String toCurrency = sc.nextLine().toUpperCase();

        if (exchangeRates.containsKey(toCurrency)) {
            double convertedAmount = amount / exchangeRates.get(toCurrency);
            System.out.println("환전된 금액: " + convertedAmount + " " + toCurrency);
        } else {
            System.out.println("지원하지 않는 통화입니다.");
        }
    }

    static void coinCounter() {
        Scanner sc = new Scanner(System.in);
        System.out.println("동전의 개수를 입력하세요 (예: 10원, 50원, 100원, 500원):");

        System.out.print("10원 동전 개수: ");
        int tenWonCount = sc.nextInt();

        System.out.print("50원 동전 개수: ");
        int fiftyWonCount = sc.nextInt();

        System.out.print("100원 동전 개수: ");
        int hundredWonCount = sc.nextInt();

        System.out.print("500원 동전 개수: ");
        int fiveHundredWonCount = sc.nextInt();
        sc.nextLine();  // 버퍼 비우기

        int totalCoinsValue = tenWonCount * 10 + fiftyWonCount * 50 + hundredWonCount * 100 + fiveHundredWonCount * 500;
        System.out.println("동전 총액: " + totalCoinsValue + "원");
    }

    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("업무를 선택하세요");
            System.out.println("입금은 1, 인출은 2, 환전은 3, 동전 계수기는 4, 종료는 9");
            int choice = sc.nextInt();
            sc.nextLine();  // 버퍼 비우기
            switch (choice) {
                case 1:
                    deposit();
                    break;
                case 2:
                    withdrawal();
                    break;
                case 3:
                    exchange();
                    break;
                case 4:
                    coinCounter();
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
