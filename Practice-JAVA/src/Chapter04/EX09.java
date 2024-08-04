package Chapter04;

public class EX09 {
    public static int solution(int n) {
        int sum = 0;

        // 1부터 n까지 반복하면서 짝수를 찾아 더합니다.
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) { // i가 짝수인지 확인
                sum += i;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        // 테스트 케이스
        System.out.println(solution(10));  // 30
        System.out.println(solution(4));   // 6
    }
}