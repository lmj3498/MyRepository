package finalsource.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import finalsource.dao.MemberDao;
import finalsource.dto.Member;

public class TestMemberDao {

	public static void main(String[] args) {
		
		//testInsert();
		//testSelectByMid();
		//testSelectByMname();
		//testUpdate();
		//testDeleteByMid();
	}

	public static void testInsert() {
		Connection conn = null;

		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "tester1", "kosa12345");
			MemberDao dao = new MemberDao();
			dao.setConn(conn);// 커넥션 세터 주입

			Member member = new Member();
			member.setMid("user10");
			member.setMname("사용자10");
			member.setMpassword("kosa12345");	
			member.setMage(26);
			member.setMbirth(new Date());

			int rowNo = dao.insert(member);
			System.out.println(rowNo + " 행이 저장됨");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.setAutoCommit(true);
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void testSelectByMid() {
		Connection conn = null;

		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "tester1", "kosa12345");
			MemberDao dao = new MemberDao();
			dao.setConn(conn);// 커넥션 세터 주입

			
			Member member = dao.selectByMid("user10");
			if(member != null){
				System.out.println(member.getMid() + " :");
				System.out.println(member.getMname() + " :");
				System.out.println(member.getMpassword() + " :");
				System.out.println(member.getMage() + " :");
				System.out.println(member.getMbirth() + " :");
			}
			
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.setAutoCommit(true);
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void testSelectByMname() {
		Connection conn = null;

		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "tester1", "kosa12345");
			MemberDao dao = new MemberDao();
			dao.setConn(conn);// 커넥션 세터 주입

			List<Member> list = dao.selectByMname("사용자10");
			for(Member member : list){
				System.out.println(member.getMid() + " :");
				System.out.println(member.getMname() + " :");
				System.out.println(member.getMpassword() + " :");
				System.out.println(member.getMage() + " :");
				System.out.println(member.getMbirth() + " :");
			}
			
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.setAutoCommit(true);
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void testUpdate() {
		Connection conn = null;

		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "tester1", "kosa12345");
			MemberDao dao = new MemberDao();
			dao.setConn(conn);// 커넥션 세터 주입

			Member member = new Member();
			member.setMid("user10");
			member.setMname("사용자10");
			member.setMpassword("kosa12345");
			member.setMage(27);
			member.setMbirth(new Date());
			int rowNo = dao.update(member);
			System.out.println(rowNo + " 행이 수정됨");
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.setAutoCommit(true);
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void testDeleteByMid() {
		Connection conn = null;

		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "tester1", "kosa12345");
			MemberDao dao = new MemberDao();
			dao.setConn(conn);// 커넥션 세터 주입

			
			int rowNo = dao.deleteByMid("user5");
			System.out.println(rowNo + " 행이 삭제됨");
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.setAutoCommit(true);
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
