package d0822;

public class Calc {
	static int add(int n1, int n2) {
		return n1 + n2;
	}
	static int minus(int n1, int n2) {
		return n1 - n2;
	}
	static int multiple(int n1, int n2) {
		return n1 * n2;
	}
	static int division(int n1, int n2) {
		return n1 / n2;
	}
	static void p(int a) {
		System.out.println(a);
	};
	public static void main(String[] args) {
		p(add(10,5));
		p(minus(10,5));
		p(multiple(10,5));
		p(division(10,5));
	}
}
