package Chater01;

import java.util.Scanner;

public class JAVA01 {

    //- user가 지는 경우 : -1, 2
    //- user가 이기는 경우 : -2, 1
    static void game01() {
        int com = (int)(Math.random() * 3);
        Scanner sc = new Scanner(System.in);
        System.out.println("가위바위보 숫자입력 : 0,1,2 >");
        int user = sc.nextInt();
        if(user - com == -1 || user - com == 2) {
            System.out.printf("user %s com %s user 패",trans(user), trans(com));
        }else if(user - com == -2 || user - com == 1) {
            System.out.printf("user %s com %s user 승",trans(user), trans(com));
        }else {
            System.out.println("비김");
        }
    }

    static void game02() {

    }

    static String trans(int i) {
        String rs = "";
        if(i == 0) rs = "가위";
        else if(i == 1) rs = "바위";
        else rs = "보";
        return rs;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("게임을 선택하세요");
        System.out.println("숫자로 입력 1, 문자로 입력 2, 종료 9");
        int choice =sc.nextInt();
        switch (choice) {
            case 1:
                game01();
                break;
            case 2:
                game02();
                break;
        }
    }
}