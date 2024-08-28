package d0823;

import java.util.Random;

public class Lotto {
    public static int[] getRandomNumberArray(int length) {
        int[] randomNumberArray = new int[length];
        for (int i = 0; i < length; i++) {
            Random r = new Random();
            int randomNum = r.nextInt(46);
            if (randomNum == 0) { // 0이면 0이 아닌 수를 넣을때까지 계속 돌려서 다른 수를 넣어.
                while (randomNum == 0) {
                    randomNum = r.nextInt(46);
                }
            }
            for (int j = 1; j < i; j++) { // 로또 번호중에 중복되는 숫자가 있으면 그 숫자는 넣지마.
                if (randomNumberArray[j] == randomNum) {
                    while (randomNum != randomNumberArray[j]) {
                        randomNum = r.nextInt(46);
                    }
                }
            }
            randomNumberArray[i] = randomNum;
        }
        return randomNumberArray;
    }

    public static void printArray(String msg, int[] numbers) {
        if (!msg.equals("") || msg != null) {
            System.out.print(msg);
        }
        if (numbers != null) {
            for (int i = 0; i < numbers.length; i++) {
                System.out.print(numbers[i] + "\t");
            }
        } else {
            System.out.println("[error message] 인티저 어레이가 안넘어와서 찍을 게 없음.");
        }
    }

    public static void printNumber(String msg, int num) {
        if (!msg.equals("") || msg != null) {
            System.out.print(msg);
        }
        if (num != 0) {
            System.out.print(num + "\t");
        } else {
            System.out.println("[error message] 인티저가 안넘어와서 찍을 게 없음.");
        }
    }

    public static void main(String[] args) {
        int[] selectNumbers = getRandomNumberArray(7);
        int[] lottoNumbers = new int[6];
        for (int i = 0; i < 6; i++) {
            lottoNumbers[i] = selectNumbers[i];
        }
        int bonusNumber = selectNumbers[selectNumbers.length - 1];

        printArray("lotto number : ", lottoNumbers);
        printNumber("\nbonus number : ", bonusNumber);
    }
}
