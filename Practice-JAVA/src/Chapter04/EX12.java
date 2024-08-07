package Chapter04;

public class EX12 {
    public static double solution(int[] arr) {
        // 배열의 모든 원소를 더할 변수를 초기화합니다.
        int sum = 0;

        // 배열의 모든 원소를 순회하면서 더합니다.
        for (int num : arr) {
            sum += num;
        }

        // 배열의 길이로 나누어 평균값을 구하고 반환합니다.
        return (double) sum / arr.length;
    }

    public static void main(String[] args) {
        // 테스트 케이스
        int[] arr1 = {1, 2, 3, 4};
        int[] arr2 = {5, 5};

        // 결과 출력
        System.out.println(solution(arr1)); // 2.5
        System.out.println(solution(arr2)); // 5.0
    }
}