package ch03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exam5 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.print("검색할 이름 : ");
			String name = scanner.nextLine();
			List<Employee> result = getList(name);
			for(Employee emp:result){
				System.out.println(emp.getEmpno()+" : "+emp.getEname());
			}
		}
		
	}

	public static List<Employee> getList(String searchName) {
		List<Employee> list = new ArrayList<>();
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "tester1", "kosa12345");
			String sql = "select * from emp where lower(ename) like ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + searchName + "%");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Employee emp = new Employee();
				emp.setEmpno(rs.getInt("empno"));
				emp.setEname(rs.getString("ename"));
				emp.setJob(rs.getString("job"));
				emp.setMgr(rs.getInt("mgr"));
				emp.setHiredate(rs.getDate("hiredate"));
				emp.setSal(rs.getDouble("sal"));
				emp.setComm(rs.getDouble("comm"));
				emp.setDeptno(rs.getInt("deptno"));
				list.add(emp);
			}
			rs.close();
			pstmt.close();
			conn.close();

		} catch (Exception e) {
			try {
				conn.close();
			} catch (SQLException e2) {
				e.printStackTrace();
			}
			e.printStackTrace();
		}
		return list;
	}
}
