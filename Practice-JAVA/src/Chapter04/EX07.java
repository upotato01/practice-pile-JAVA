package Chapter04;

public class EX07  {
    public int solution(int num1, int num2) {
        // num1을 num2로 나눈 값을 계산
        double divisionResult = (double) num1 / num2;

        // 결과에 1000을 곱함
        double multipliedResult = divisionResult * 1000;

        // 정수 부분을 반환
        return (int) multipliedResult;
    }

    public static void main(String[] args) {
        EX07  sol = new EX07 ();

        // 예제 테스트 케이스
        System.out.println(sol.solution(3, 2));  // 1500
        System.out.println(sol.solution(7, 3));  // 2333
        System.out.println(sol.solution(1, 16)); // 62
    }
}