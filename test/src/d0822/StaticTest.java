package d0822;

public class StaticTest {
	static int age = 10;
	String name = "홍길동";
	//멤버변수
//상수는  대문자로 하고 두 단어면 언더바로 표현한다.	
	public static void main(String[] args) {
		StaticTest st = new StaticTest();
		StaticTest.age = 20;
		StaticTest st2 = new StaticTest();
		System.out.println(st.age);  //스태틱은 미리 메모리를 실행해놓고 다시는 실행 하지 않는다.  공통으로 쓴다.
	}
}
