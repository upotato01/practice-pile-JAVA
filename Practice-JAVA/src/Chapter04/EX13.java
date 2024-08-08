package Chapter04;

public class EX13 {
    public int solution(int N) {
        // 1. N을 문자열로 변환
        String strN = Integer.toString(N);

        // 2. 자릿수의 합을 저장할 변수
        int sum = 0;

        // 3. 문자열의 각 자릿수를 순회하며 합을 구함
        for (int i = 0; i < strN.length(); i++) {
            // 각 자릿수를 문자에서 정수로 변환 후 더함
            sum += Character.getNumericValue(strN.charAt(i));
        }

        // 4. 최종 합을 반환
        return sum;
    }

    public static void main(String[] args) {
        EX13 sol = new EX13();

        // 테스트 케이스
        int N1 = 123;
        int result1 = sol.solution(N1);
        System.out.println("N = " + N1 + " -> " + result1);  // 출력: N = 123 -> 6

        int N2 = 987;
        int result2 = sol.solution(N2);
        System.out.println("N = " + N2 + " -> " + result2);  // 출력: N = 987 -> 24
    }
}