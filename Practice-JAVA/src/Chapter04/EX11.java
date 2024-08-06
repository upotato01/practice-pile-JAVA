package Chapter04;

public class EX11 {
    public String solution(int num) {
        // num이 짝수인지 홀수인지 판단하여 결과를 반환
        if (num % 2 == 0) {
            return "Even";
        } else {
            return "Odd";
        }
    }

    // 테스트 메소드
    public static void main(String[] args) {
        EX11 sol = new EX11();

        // 테스트 케이스 1
        int test1 = 3;
        System.out.println("Input: " + test1 + " -> Output: " + sol.solution(test1)); // 출력: "Odd"

        // 테스트 케이스 2
        int test2 = 4;
        System.out.println("Input: " + test2 + " -> Output: " + sol.solution(test2)); // 출력: "Even"

        // 추가 테스트 케이스
        int test3 = 0;
        System.out.println("Input: " + test3 + " -> Output: " + sol.solution(test3)); // 출력: "Even"
    }
}