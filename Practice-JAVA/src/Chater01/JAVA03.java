package Chater01;

import java.util.Scanner;

public class JAVA03 {
    public static void main(String[] args) {
    //학점 매기기 문서
        Scanner scanner = new Scanner(System.in);
        char grade;
        System.out.printf("시험 점수를 입력해주세요: (0~100점)");
        int score = scanner.nextInt();
        switch (score/10){
            case 10: //score = 100
            case 9: //score = 90~99
                grade = 'A';
                break;
            case 8:  //score = 80~89
                grade = 'B';
                break;
            case 7:
                grade = 'C';
                break;
            case 6:
                grade = 'D';
                break;
            default:
                grade = 'F';
        }
        System.out.printf("학점은 " + grade + " 입니다");
    }
}
