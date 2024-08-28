package d0823;

public class ArrayTest3 {
    public static void main(String[] args) {
        String[] strArray = new String[4];
        for (int i = 0; i < strArray.length; i++) {
            strArray[i] = Integer.toString((i + 1) * 10);
            System.out.println(strArray[i]);
        }
    }
}
