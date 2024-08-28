package d0822;

public class Condition2 {
	public static void main(String[] args) {
		String str = "1";
		String str1 = "1";
		
		String str2 = new String("1");
		
		System.out.println(str == str2);
		System.out.println(str.equals(str2)); //값이 중요함.
		if(str1.equals(str2)) {
			System.out.println("str, str1 같음");
		}else if(str.equals(str2)) {
			System.out.println("str, str2 같음");
		}else {
			System.out.println("false");
		}
		
	}
}
