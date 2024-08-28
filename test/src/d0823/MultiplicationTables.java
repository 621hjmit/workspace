package d0823;

public class MultiplicationTables {
    public static void main(String[] args) {

        // 이중 배열과 다중 포문으로 구구단 출력.

        int[][] nums = new int[8][9];
        for (int i = 0; i < 8; i++) {
            System.out.println("\n\n" + (i + 2) + "단\n");
            for (int j = 0; j < 9; j++) {
                nums[i][j] = (i + 2) * (j + 1);
                System.out.println((i + 2) + "*" + (j + 1) + "=" + nums[i][j]);
            }
        }
    }
}
