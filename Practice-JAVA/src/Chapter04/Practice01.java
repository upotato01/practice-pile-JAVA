package Chapter04;

import java.util.Random;

public class Practice01 {

    private String[] firstList = {"기철초풍", "멋있는", "재미있는"};
    private String[] secondList = {"도전적인", "노란색의", "바보같은"};
    private String[] thirdList = {"돌고래", "개발자", "오랑우탄"};

    public String createRandomNickname() {
        // 여기에 랜덤으로 닉네임을 만드는 코드를 적어주세요
        Random random = new Random();

        int index1 = random.nextInt(firstList.length);
        int index2 = random.nextInt(secondList.length);
        int index3 = random.nextInt(thirdList.length);

        String answer = firstList[index1] + secondList[index2] + thirdList[index3];
        return (answer);
    }

    public static void main(String[] args) {
        Practice01 randomNicknameCreator = new Practice01();
        String myNickname = randomNicknameCreator.createRandomNickname();
        System.out.println(myNickname);
    }
}