package ch02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Exam4 {

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
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("찾고자하는 부서명 일부분을 입력하시오 : ");
		String temp = "%"+scanner.nextLine()+"%";
		
		//매개변수화된 SQL문
		//부서명을 조건으로 해서 부서명 일부분을 입력했을 때
		//부서가 존재할 경우, 부서번호, 부서이름을 출력
		//부서가 존재하지 않을 경우 "부서가 없음" 출력
		String sql = "select deptno,dname from dept ";
		sql += "where dname like ?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, temp);
		
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()){
			do{
				int deptno = rs.getInt("deptno");
				String dname = rs.getString("dname");
				System.out.println(deptno+" : "+dname);
			}while(rs.next());
			
		}else{
			System.out.println("부서가 없음");
		}
		
		
		rs.close();
		pstmt.close();
		//db 연결 끝는 작업(반드시, 자원과 관련되는 부분이며, 라이센스(돈)과 관련되기 때문!
		conn.close();
		
	}

}
