package d0823;

import java.util.HashSet;
import java.util.Set;

public class SetTest {
    public static void main(String[] args) {
        Set<String> strs = new HashSet<String>();
        strs.add("1");
        strs.add("1");
        strs.add("1");
        strs.add("1");
        System.out.println("size: " + strs.size());
        System.out.println("entity: " + strs);
    }
}
