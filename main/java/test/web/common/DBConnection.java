package test.web.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {

	public static void test() {
		System.out.println("안녕 난 test()메서드야");
	}

	public static void main(String[] args) {
		String id = "root";
		String pwd = "r1r2r3";
		String driverName = "org.mariadb.jdbc.Driver";
		String url = "jdbc:mariadb://localhost:3307/ezen";

		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {
			Connection con = DriverManager.getConnection(url, id, pwd);
			String sql = "INSERT INTO user_info(UI_NAME, UI_ID, UI_PWD, CREDAT, CRETIM)\r\n"
					+ "VALUES('DongDong','dd','123123','20240826','221010')";
			Statement stmt = con.createStatement();
			int result = stmt.executeUpdate(sql);
			if (result == 1) {
				System.out.println("잘 입력이 되었습니다.");
			} else {
				System.out.println("뭔지 모르겠는데 오류났음!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
