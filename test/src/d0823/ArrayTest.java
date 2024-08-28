package d0823;

class ArrayTest {
    public static void main(String[] args) {
        int[] num = new int[3];
        num[0] = 10;
        num[1] = 24;
        num[2] = 38;

        int[] nums = new int[4];
        int[] tmps = new int[4];

        for (int i = 0; i < num.length; i++) {
            tmps[i] = num[i];
        }
        for (int i = 0; i < tmps.length; i++) {
            nums[i] = tmps[i];
            System.out.println(nums[i]);
        }
    }
}