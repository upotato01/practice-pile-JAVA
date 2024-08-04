package Chapter04;

public class EX08 {
    public static int solution(int angle) {
        if (angle > 0 && angle < 90) {
            return 1; // 예각
        } else if (angle == 90) {
            return 2; // 직각
        } else if (angle > 90 && angle < 180) {
            return 3; // 둔각
        } else if (angle == 180) {
            return 4; // 평각
        } else {
            return -1; // 제한 사항에 의해 0 < angle ≤ 180이므로 여기에 도달하지 않음
        }
    }

    public static void main(String[] args) {
        // 테스트 케이스
        System.out.println(solution(70));  // 1
        System.out.println(solution(91));  // 3
        System.out.println(solution(180)); // 4
    }
}
