package ch02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Exam02 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		/*Driver oracleDriver = new OracleDriver();
		DriverManager.registerDriver(oracleDriver);
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "tester1", "kosa12345");
		*/
		
		
		//경로에 대한 클래스를 메모리에 로딩하겠다는 뜻(메소드 영역에 static블록을 실행 함)
		//결국  DriverManager가 이 정보를 이용함
		//static블록 안에, OracleDriver객체를 DrivverManager에 등록하는 크드가 존재(registerDriver(Driver driver) 와 같은..)
		//Driver oracleDriver = new OracleDriver();
		//DriverManager.registerDriver(oracleDriver);
		Class.forName("oracle.jdbc.OracleDriver");
		
		//db 연결 객체
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "tester1", "kosa12345");
		//위에 부분, Connection Pool 사용해야 함(db연결이 가장 시간이 오래 걸리므로)
		
		//매개변수화된 SQL문(select문)(문자열 일부분을 ?처리 할 수 없음)
		String sql = "select ename,empno,sal from emp where ename like ?";//바뀌는 부분은 ? 처리(값이 들어오는 부분)//
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, "%성%");
		
		//sql을 oracle에서 실행
		//실제 db의 데이터 셋이 아닌, sql의 결과 셋이 담기므로 열과 값에 대해 헷갈리면 안됨
		//before first에서부터 커서 진행되며 after last전까지 데이터 존재
		//next() 메소드를 이용하여 데이터 존재 true/false
		//데이터 읽을 때는 RS의 get~()메소드를 이용함
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			int empno = rs.getInt(2);
			String ename =rs.getString("ename");
			int sal =rs.getInt("sal");
			System.out.println(empno+":"+ename+":"+sal);
		}
		
		
		rs.close();
		pstmt.close();
		//db 연결 끝는 작업(반드시, 자원과 관련되는 부분이며, 라이센스(돈)과 관련되기 때문!
		conn.close();
		
	}

}
