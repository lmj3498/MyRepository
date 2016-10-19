package ch08.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ch08.dto.Account;

public class AccountDao {
	private Connection conn;

	public void setConn(Connection conn) {
		this.conn = conn;
	}
	
	public int update(Account account) throws SQLException{
		String sql = "update account set abalance = ? where ano = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, account.getAbalance());
		pstmt.setString(2, account.getAno());
		int rowNo = pstmt.executeUpdate();
		
		//몇 개의 행이 리턴 됐는지 알기 위해 리턴 타입을 부여함
		return rowNo;
	}
}
