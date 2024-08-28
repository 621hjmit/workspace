package d0823;

import java.util.ArrayList;
import java.util.List;

public class ListTest3 {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        nums.add(3);
        nums.add(13);
        nums.add(31);
        nums.add(33);
        nums.add(15);

        System.out.println(nums.indexOf(44));
        /*
         * for (int i = 0; i < nums.size(); i++) {
         * if (nums.get(i) == 13) {
         * System.out.println("value: " + nums.get(i));
         * System.out.println("index: " + i);
         * break;
         * }
         * }
         */
    }
}
