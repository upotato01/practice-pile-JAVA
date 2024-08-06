package Chapter04;

public class EX10 {
    public double solution(int[] numbers) {
        // 배열의 원소 합을 계산
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }

        // 배열의 길이로 합을 나누어 평균값을 계산
        double average = (double) sum / numbers.length;

        return average;
    }

    // 테스트 메소드
    public static void main(String[] args) {
        EX10 sol = new EX10();

        int[] test1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(sol.solution(test1)); // 출력: 5.5

        int[] test2 = {89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99};
        System.out.println(sol.solution(test2)); // 출력: 94.0
    }
}