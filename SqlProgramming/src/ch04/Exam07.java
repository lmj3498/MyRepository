package ch04;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Exam07 {
	
	public static void main(String[] args) {
		String job = null; int value = 0;
		//InputStream is = null;
		Scanner sc = new Scanner(System.in);
		System.out.print("제외하고자 하는 직급 : ");
		job = String.valueOf(sc.nextLine()); 
		System.out.print("봉급 합 : ");
		value = sc.nextInt();
		List<JobSalary> result = getMethod(job,value);
		
		for(JobSalary js : result){
			System.out.println(js.getJob()+" : "+js.getSalary());
		}
	}

	private static List<JobSalary> getMethod(String job, int value) {
		List<JobSalary> list = new ArrayList<>();
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "tester1", "kosa12345");
			String sql = "select job, sum(sal) as salary from emp where job != ? group by job having sum(sal) >= ? order by salary";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, job);
			pstmt.setInt(2, value);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()){
				JobSalary js = new JobSalary();
				js.setJob(rs.getString("job"));
				js.setSalary(rs.getDouble("salary"));
				list.add(js);
			}
			rs.close();
			pstmt.close();
		} catch (Exception e) {
			System.out.println("예외가 발생했습니다.");
			e.printStackTrace();
		}finally{
			try {conn.close();} catch (SQLException e) {e.printStackTrace();}
		}
		
		return list;
	}

}
