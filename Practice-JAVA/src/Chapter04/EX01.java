package chapter02;

public class EX01 {
    public int ex01(int num1, int num2) {
        // 입력값 범위 체크
        if (check(num1) && check(num2)) {
            // 연산
            return num1 - num2;
        }
        // 범위 밖의 값이 주어졌을 경우 예외 처리를 위한 반환값 (문제의 조건상 필요하지 않음)
        return 0;
    }

    private boolean check(int num) {
        return num >= -50000 && num <= 50000;
    }

    public static void main(String[] args) {
        EX01 solution = new EX01();

        // 테스트 케이스 1
        int result1 = solution.ex01(2, 3);
        System.out.println("결과: " + result1); // 출력: 결과: -1

        // 테스트 케이스 2
        int result2 = solution.ex01(100, 2);
        System.out.println("결과: " + result2); // 출력: 결과: 98
    }
}
