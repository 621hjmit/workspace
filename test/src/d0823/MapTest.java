package d0823;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
    public static void main(String[] args) {
        // List , Map, Set
        Map<String, String> m = new HashMap<String, String>();
        m.put("이름", "경훈");
        m.put("주소", "서울");
        System.out.println(m);
    }
}
