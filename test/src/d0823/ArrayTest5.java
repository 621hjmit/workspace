package d0823;

import java.util.ArrayList;
import java.util.List;

class ArrayTest5 {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<Integer>();
        nums.add(10);
        nums.add(5);
        nums.add(7);
        nums.add(1);
        nums.add(8);
        System.out.println(nums); // 순서 맞춘 구성원이 나온다.
        // 스트링처럼 안에서 뭔가 해준다.

        Integer[] nums2 = new Integer[5];
        nums2[0] = 10;
        nums2[1] = 5;
        nums2[2] = 7;
        nums2[3] = 1;
        nums2[4] = 8;
        System.out.println(nums2);

        String str = new String("hi");
        System.out.println(str);

    }
}