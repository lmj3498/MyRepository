package ch02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Exam01 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		//어떤 JDBC Driver를 사용할 것인가(JDBC Driver 로딩)
		//Class.forName("oracle.jdbc.driver.OracleDriver");// 8i~9i까지(옛날 방식)
		Class.forName("oracle.jdbc.OracleDriver");//10g부터(최신 방식)
		
		//연결 요청을 해서 연결 객체를 얻기
		Connection conn = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:orcl", 
				"tester1", "kosa12345"
		);
		
		
		//SQL문을 보내고 실행시킴
		String sql = "select empno, ename from emp";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		
		//결과셋에서 한 행씩 읽기(커서의 위치를 한 행씩 내림)(현재 커서가 있는 행만 읽을 수 있으므로)
		//next() 커서를 이동시키고 데이터가 있으면 true , 없으면 false 리턴
		while(rs.next()){
			//데이터 얻는 부분
			String empno = rs.getString("empno");
			String ename = rs.getString("ename");
			System.out.println(empno + " : " + ename);
			
		}
		
		//JDBC 관련 객체 닫기(메모리 리소스 해제)
		rs.close();
		pstmt.close();
		conn.close();
	}
}
