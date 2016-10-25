package com.mycompany.myapp.exam12.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.mycompany.myapp.exam12.dto.Member;


@Component
public class Exam12Dao {
	
	private Connection conn;
	public void setConn(Connection conn) {
		this.conn = conn;
	}
	
	//1 or 예외
	public int insert(Member member) throws SQLException{
		String sql = "insert into member(mid, mname, mpassword, mage, mbirth) values(?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, member.getMid());
		pstmt.setString(2, member.getMname());
		pstmt.setString(3, member.getMpassword());
		pstmt.setInt(4, member.getMage());
		pstmt.setDate(5, new Date(member.getMbirth().getTime()));
		int rowNo = pstmt.executeUpdate();
		
		pstmt.close();
		return rowNo;
	}
	
	//member or null
	public Member selectByMid(String mid) throws SQLException{
		Member member = new Member();
		String sql = "select mid, mname, mpassword, mage, mbirth from member where mid = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, mid);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()){
			member.setMid(rs.getString("mid"));
			member.setMname(rs.getString("mname"));
			member.setMpassword(rs.getString("mpassword"));
			member.setMage(rs.getInt("mage"));
			member.setMbirth(rs.getDate("mbirth"));
		}
		
		pstmt.close();
		return member;
	}
	
	//list or 비어있는 list
	public List<Member> selectByMname(String mname) throws SQLException{
		List<Member> list = new ArrayList<>();
		String sql = "select mid, mname, mpassword, mage, mbirth from member where mname like ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, "%"+mname+"%");
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			Member member = new Member();
			member.setMid(rs.getString("mid"));
			member.setMname(rs.getString("mname"));
			member.setMpassword(rs.getString("mpassword"));
			member.setMage(rs.getInt("mage"));
			member.setMbirth(rs.getDate("mbirth"));
			list.add(member);
		}
		rs.close();
		pstmt.close();
		return list;
	}
	
	//수정된 행수 or 예외
	public int update(Member member) throws SQLException{
		String sql = "update member set mname = ?, mpassword=?, mage = ?, mbirth = ? where mid = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, member.getMname());
		pstmt.setString(2, member.getMpassword());
		pstmt.setInt(3, member.getMage());
		pstmt.setDate(4, new Date(member.getMbirth().getTime()));
		pstmt.setString(5, member.getMid());
		int rowNo = pstmt.executeUpdate();
		
		pstmt.close();
		return rowNo;
	}
	
	//삭제된 행수 or 0 or 예외
	public int deleteByMid(String mid) throws SQLException{
		String sql = "delete member where mid = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, mid);
		int rowNo = pstmt.executeUpdate();
		
		pstmt.close();
		return rowNo;
	}
}
