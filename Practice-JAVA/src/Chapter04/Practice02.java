package Chapter04;

import java.util.Random;

public class Practice02 {

    private String[] firstList = {"기철초풍", "멋있는", "재미있는"};
    private String[] secondList = {"도전적인", "노란색의", "바보같은"};
    private String[] thirdList = {"돌고래", "개발자", "오랑우탄"};

    public String createRandomNickname() {
        // Create a Random object
        Random random = new Random();

        // Generate random indexes for each list
        int index1 = random.nextInt(firstList.length);
        int index2 = random.nextInt(secondList.length);
        int index3 = random.nextInt(thirdList.length);

        // Create the random nickname
        String randomNickname = firstList[index1] + " " + secondList[index2] + " " + thirdList[index3];
        return randomNickname;
    }

    public static void main(String[] args) {
        Practice02 randomNicknameCreator = new Practice02();
        String myNickname = randomNicknameCreator.createRandomNickname();
        System.out.println(myNickname);
    }
}