package ch03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exam06 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("찾고자하는 사원 번호를 입력하세요 : ");
		int num = Integer.parseInt(sc.nextLine());
		Employee emp = getEmployee(num);// 사원정보를 employee객체로 리턴하도록
		System.out.println(emp.getEmpno() + " : " + emp.getEname() + " : " + emp.getSal());
		
		//--------------------------------------------------------------------------------
		System.out.print("찾고자하는 사원 부서를 입력하세요 : ");
		String str = "%"+sc.nextLine()+"%";
		List<Department> result = getDepartment(str);
		for (Department dept : result) {
			System.out.println(dept.getDeptno() + " : " + dept.getDname() + " : " + dept.getLoc());
		}
	}

	private static Employee getEmployee(int searchEmpno) {
		Employee emp = null;
		Connection conn = null;

		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "tester1", "kosa12345");
			String sql = "select empno, ename, sal from emp where empno = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, searchEmpno);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				emp = new Employee();
				emp.setEmpno(rs.getInt("empno"));
				emp.setEname(rs.getString("ename"));
				emp.setSal(rs.getInt("sal"));
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {conn.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return emp;
	}

	private static List<Department> getDepartment(String searchDname) {
		
		List<Department> list = new ArrayList<>();
		Department dept = null;
		Connection conn = null;
		try {
			
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "tester1", "kosa12345");
			String sql = "select deptno,dname,loc from dept where dname like ?";
			PreparedStatement pmtst = conn.prepareStatement(sql);
			pmtst.setString(1, searchDname);
			ResultSet rs = pmtst.executeQuery();
			
			while(rs.next()){
				dept = new Department();
				dept.setDeptno(rs.getInt("deptno"));
				dept.setDname(rs.getString("dname"));
				dept.setLoc(rs.getString("loc"));
				list.add(dept);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {conn.close();} catch (SQLException e) {e.printStackTrace();}
		}
		
		
		return list;
	}

}
