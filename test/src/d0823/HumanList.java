package d0823;

import java.util.ArrayList;
import java.util.List;

public class HumanList {
    public static void main(String[] args) {
        List<Human> people = new ArrayList<Human>();
        Human d = new Human("동동이", 27, "남");
        Human n = new Human("니니", 36, "여");
        Human s = new Human("슈카", 47, "남");
        people.add(d);
        people.add(n);
        people.add(s);
        System.out.println(people);
        for (int i = 0; i < people.size(); i++) {
            System.out.println(people.get(i));
        }
    }
}
