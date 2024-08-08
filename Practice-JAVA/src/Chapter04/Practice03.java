package Chapter04;

import java.util.Map;
import java.util.Scanner;

public class Practice03 {

    public static void main(String[] args) {
        // Step 1: 음료 이름과 가격을 저장하는 맵을 생성합니다
        Map<String, Integer> beverages = Map.of(
                "사이다", 1700,
                "콜라", 1900,
                "식혜", 2500,
                "솔의눈", 3000
        );

        // Step 2: 음료와 가격을 표시합니다
        System.out.println("음료 메뉴:");
        for (Map.Entry<String, Integer> beverage : beverages.entrySet()) {
            System.out.println(beverage.getKey() + ": " + beverage.getValue() + "원");
        }

        // Step 3: 사용자로부터 음료 선택을 입력받습니다
        Scanner scanner = new Scanner(System.in);
        System.out.print("어떤 음료를 선택하시겠습니까? ");
        String userChoice = scanner.nextLine();

        // Step 4: 선택한 음료가 목록에 있는지 확인합니다
        if (beverages.containsKey(userChoice)) {
            // Step 5: 사용자가 넣을 돈을 입력받습니다
            System.out.print("얼마를 넣으시겠습니까? ");
            int coin = scanner.nextInt();

            // Step 6: 넣은 돈이 충분한지 확인합니다
            if (coin < beverages.get(userChoice)) {
                System.out.println("돈이 부족합니다.");
            } else {
                // Step 7: 잔액을 계산하고 표시합니다
                int remain = coin - beverages.get(userChoice);
                System.out.println(userChoice + "(을/를) 구매하셨습니다.");
                System.out.println("잔액: " + remain + "원");
            }
        } else {
            // 목록에 없는 음료를 선택한 경우
            System.out.println("목록에 없는 음료입니다. 실행을 종료합니다.");
        }

        // 스캐너를 닫습니다
        scanner.close();
    }
}