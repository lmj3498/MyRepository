package finalsource.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import finalsource.dao.BoardDao;
import finalsource.dto.Board;
import finalsource.dto.Member;

public class TestBoardDao {

	public static void main(String[] args) {
		testInsert();
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
			BoardDao dao = new BoardDao();
			dao.setConn(conn);// 커넥션 세터 주입

			Board board = new Board();
			//board.setBno(1);//시퀀스를 이용하게 되므로
			board.setBtitle("제목1");
			board.setBcontent("내용1");
			board.setBwriter("user10");
			//board.setBhitcount(0);
			//board.setBdate(new Date());

			int rowNo = dao.insert(board);
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
			BoardDao dao = new BoardDao();
			dao.setConn(conn);// 커넥션 세터 주입

			Board board = dao.selectByBno(1);
			if (board != null) {
				System.out.println(board.getBno() + " :");
				System.out.println(board.getBtitle() + " :");
				System.out.println(board.getBcontent() + " :");
				System.out.println(board.getBwriter() + " :");
				System.out.println(board.getBhitcount() + " :");
				System.out.println(board.getBdate() + " :");

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
			BoardDao dao = new BoardDao();
			dao.setConn(conn);// 커넥션 세터 주입

			List<Board> list = dao.selectByBtitle("제목1");
			for (Board board : list) {
				System.out.println(board.getBno() + " :");
				System.out.println(board.getBtitle() + " :");
				System.out.println(board.getBcontent() + " :");
				System.out.println(board.getBwriter() + " :");
				System.out.println(board.getBhitcount() + " :");
				System.out.println(board.getBdate() + " :");
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
			BoardDao dao = new BoardDao();
			dao.setConn(conn);// 커넥션 세터 주입

			Board board = new Board();
			board.setBno(1);
			board.setBtitle("제목1");
			board.setBcontent("내용1");
			board.setBwriter("user10");
			board.setBhitcount(1);
			board.setBdate(new Date());
			int rowNo = dao.update(board);
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
			BoardDao dao = new BoardDao();
			dao.setConn(conn);// 커넥션 세터 주입

			int rowNo = dao.deleteByBno(1);
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
