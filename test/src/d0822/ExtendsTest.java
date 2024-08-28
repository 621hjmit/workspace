package d0822;

class Mother {
    public void work() {
        System.out.println("회사에 출근.");
    }

    public void attack() {
        System.out.println("등짝 스매싱");
    }
}

class Son extends Mother {
    public void work() { // 오버라이딩 올라탔으니까 ㅎ
        System.out.println("학교에 등교.");
    }

    public void play() {
        System.out.println("롤 재밌다.");
    }
}

public class ExtendsTest {
    public static void main(String[] args) {
        // 자바에서의 상속은 확장을 의미
        Mother m = new Son();
        s.work();
        if (m instanceof Son) {
            // m아 son이라고 불러도되니?
            Son s = (Son) m; // 오류납니다.
            s.attack();
            s.play();
        }

        // 위에 있는 마더는 손이 모하는지 몰름.

    }
}
// new 라고 하면서 메모리를 만드는 것을 인스턴스화라고 함. 인스턴스오브는 너 그 인스턴스냐 묻는 거임.