package Chapter04;

public class EX05  {
    public int solution(int num1, int num2) {
        // 두 수가 같으면 1을 반환, 다르면 -1을 반환
        return num1 == num2 ? 1 : -1;
    }

    public static void main(String[] args) {
        EX05  sol = new EX05 ();
        // 테스트 케이스
        System.out.println(sol.solution(2, 3));   // -1
        System.out.println(sol.solution(11, 11)); // 1
        System.out.println(sol.solution(7, 99));  // -1
    }
}