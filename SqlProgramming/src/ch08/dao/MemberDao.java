package ch08.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ch08.dto.Member;

public class MemberDao {
	public void insert(Member member){
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "tester1", "kosa12345");
			String sql="insert into member(mid, mname, mage, mbirth) values(?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, member.getMid());
			pstmt.setString(2, member.getMname());
			pstmt.setInt(3, member.getMage());
			pstmt.setDate(4, new Date(member.getMbirth().getTime())); //중요
			
			//굳이 if문은 필요 없음, 확인 차
			int rowNo = pstmt.executeUpdate();
			if(rowNo == 1){
				System.out.println("저장 성공");
			}
			
			pstmt.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("예외가 발생함");
			e.printStackTrace();
		}finally{
			try {conn.close();} catch (SQLException e) {e.printStackTrace();}
		}
	}

	public void update(Member member) {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "tester1", "kosa12345");
			String sql="update member set mage = ?, mbirth = ? where mid = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, member.getMage());
			pstmt.setDate(2, new Date(member.getMbirth().getTime())); //중요
			pstmt.setString(3, member.getMid());
			
			//굳이 if문은 필요 없음, 확인 차
			int rowNo = pstmt.executeUpdate();
			if(rowNo >= 1){
				System.out.println(rowNo+"개의 행이 업데이트 됨");
			}else if(rowNo == 0){
				System.out.println("어떤 데이터도 수정되지 않았음");
			}
			pstmt.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("예외가 발생함");
			e.printStackTrace();
		}finally{
			try {conn.close();} catch (SQLException e) {e.printStackTrace();}
		}
		
	}

	public void delete(String mid) {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "tester1", "kosa12345");
			String sql="delete member where mid = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			
			int rowNo = pstmt.executeUpdate();
			if(rowNo >= 1){
				System.out.println(rowNo+"개의 행이 삭제 됨");
			}else if(rowNo == 0){
				System.out.println("어떤 데이터도 수정되지 않았음");
			}
			pstmt.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("예외가 발생함");
			e.printStackTrace();
		}finally{
			try {conn.close();} catch (SQLException e) {e.printStackTrace();}
		}
		
	}
}
