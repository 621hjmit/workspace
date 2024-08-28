package test.web.common;

public class ExceptionTest {
	
	public static int parseInt(String str) throws Exception{
		return Integer.parseInt(str);
	}

	public static void connection() {
		System.out.println("뭔지 모르는데 연결메서드야~~");
	}
	
	public static void main(String[] args) {
		ExceptionTest.connection();
		try {
			ExceptionTest.parseInt("2.1");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
