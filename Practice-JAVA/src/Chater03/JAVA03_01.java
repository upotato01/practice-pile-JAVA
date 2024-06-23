package Chater03;

import java.util.Scanner;

public class JAVA03_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] scores = new int[4]; // 0: E/I, 1: S/N, 2: T/F, 3: J/P

        // 질문 리스트
        String[] questions = {
                "1. 다른 사람들과 함께 시간을 보내는 것을 즐기십니까? (E) 아니면 혼자 있는 것을 더 좋아하십니까? (I)",
                "2. 현재의 사실과 정보를 중시하십니까? (S) 아니면 가능성과 의미를 중시하십니까? (N)",
                "3. 논리적이고 객관적인 결정을 내리십니까? (T) 아니면 감정과 가치를 중시하십니까? (F)",
                "4. 계획을 세우고 조직적으로 행동하는 것을 선호하십니까? (J) 아니면 즉흥적으로 행동하는 것을 선호하십니까? (P)"
        };

        char[] types = {'E', 'S', 'T', 'J'};
        char[] opposites = {'I', 'N', 'F', 'P'};

        // 질문에 대한 답변 받기
        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i]);
            System.out.print("답변 (E/I, S/N, T/F, J/P): ");
            char answer = scanner.next().charAt(0);

            // 점수 계산
            if (answer == types[i]) {
                scores[i]++;
            } else if (answer == opposites[i]) {
                scores[i]--;
            } else {
                System.out.println("잘못된 입력입니다. 프로그램을 종료합니다.");
                return;
            }
        }

        // MBTI 유형 계산
        char[] result = new char[4];
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] >= 0) {
                result[i] = types[i];
            } else {
                result[i] = opposites[i];
            }
        }

        // 결과 출력
        System.out.print("당신의 MBTI 유형은: ");
        for (char c : result) {
            System.out.print(c);
        }
        System.out.println();

        scanner.close();
    }
    /*
    MBTI 검사를 위한 Java 코드는 사용자가 몇 가지 질문에 답하도록 하고, 각 질문에 대한 답변을 바탕으로 MBTI 유형을 계산하는 방식으로 작성할 수 있습니다. 
    이 예제에서는 간단한 콘솔 기반의 MBTI 검사를 구현합니다.

    코드 설명

	1.	질문과 답변: MBTI 검사를 위해 질문 목록과 각 질문에 대한 답변을 준비합니다.
	2.	점수 계산: 각 질문에 대해 사용자의 답변을 받아서 MBTI 유형을 계산합니다.
	3.	결과 출력: 최종적으로 사용자의 MBTI 유형을 출력합니다.
    
    코드 설명

	•	변수 초기화: scores 배열을 통해 각 MBTI 차원(E/I, S/N, T/F, J/P)에 대한 점수를 저장합니다.
	•	질문 반복: 질문을 하나씩 출력하고, 사용자로부터 답변을 입력받습니다.
	•	답변 처리: 사용자가 입력한 답변이 올바른지 확인하고, 각 차원의 점수를 업데이트합니다.
	•	결과 계산: 각 차원의 점수를 바탕으로 최종 MBTI 유형을 결정합니다.
	•	결과 출력: 최종 MBTI 유형을 출력합니다.

    이 코드는 간단한 형태의 MBTI 검사이며, 실제로 더 많은 질문과 복잡한 논리를 추가하여 정확도를 높일 수 있습니다.
    */
}
