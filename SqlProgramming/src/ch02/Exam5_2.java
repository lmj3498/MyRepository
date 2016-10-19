package ch02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exam5_2 {

	public static void main(String[] args){
		Connection conn=null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			Scanner scanner = new Scanner(System.in);
			while(true){
				System.out.print("검색할 이름 : ");
				String name = scanner.nextLine();
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "hr", "kosa12345");
				String sql = "select employee_id, first_name from employees where lower(first_name) like ?";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "%"+name+"%");
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()){
					int employee_id = rs.getInt(1);
					String first_name = rs.getString(2);
					System.out.println(employee_id+":"+first_name);
				}
				rs.close();
				pstmt.close();
				conn.close();
			}
		} catch (Exception e) {
			try {conn.close();} catch (SQLException e2) {e.printStackTrace();}
			e.printStackTrace();
		}
		
	}
	
	
}
