package ch08.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ch08.dto.Board;
import ch08.dto.Member;

public class BoardDao {
	public void insert(Board board){
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "tester1", "kosa12345");
			String sql="insert into board values(?,?,?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, board.getBno());
			pstmt.setString(2, board.getBtitle());
			pstmt.setString(3, board.getBcontent());
			pstmt.setString(4, board.getBwriter());
			pstmt.setInt(5, board.getBhitcount());
			pstmt.setDate(6, new Date(board.getBdate().getTime())); //중요
			
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

	public void update(Board board) {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "tester1", "kosa12345");
			String sql="update board set btitle = ?, bcontent = ?, bwriter = ? where bno = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getBtitle());
			pstmt.setString(2, board.getBcontent());
			pstmt.setString(3, board.getBwriter());
			pstmt.setInt(4, board.getBno());
			
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

	public void delete(int bno) {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "tester1", "kosa12345");
			String sql="delete board where bno = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			
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
