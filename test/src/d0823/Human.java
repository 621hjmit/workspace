package d0823;

public class Human {
    String name;
    int age;
    String gender;

    public Human(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Human [name=" + name + ", age=" + age + ", gender=" + gender + "]";
    }

    public static void main(String[] args) {
        Human h = new Human("동동이", 10, "남");
        System.out.println(h.name);
    }
}
