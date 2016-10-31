package com.mycompany.myweb.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.mycompany.myweb.dto.FreeBoard;

@Component
public class FreeBoardDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public int insert(FreeBoard freeboard){
		String sql = "insert into freeboard(bno,btitle,bcontent,bwriter,bhitcount,bdate) values(seq_freeboard_bno.nextval,?,?,?,0,sysdate)";
		
		int row = jdbcTemplate.update(
				sql, 
				freeboard.getBtitle(),
				freeboard.getBcontent(),
				freeboard.getBwriter()
				);
		return row;
	}
	
	public int update(FreeBoard freeboard){
		String sql = "update freeboard set btitle=?,bcontent=?,bhitcount=? where bno = ?";
		
		int row = jdbcTemplate.update(
				sql, 
				freeboard.getBtitle(),
				freeboard.getBcontent(),
				freeboard.getBhitcount(),
				freeboard.getBno()
				);
		return row;
	}
	
	public int delete(int bno){
		String sql = "delete from freeboard where bno=?";
		int row = jdbcTemplate.update(sql, bno);
		return row;
		
	}
	
	public FreeBoard selectByBno(int bno){
		String sql = "select bno,btitle,bcontent,bwriter,bhitcount,bdate from freeboard where bno = ?";
		List<FreeBoard> list = jdbcTemplate.query(sql, new Object[]{bno}, new RowMapper<FreeBoard>(){
			@Override
			public FreeBoard mapRow(ResultSet rs, int row) throws SQLException {
				FreeBoard freeboard = new FreeBoard();
				freeboard.setBno(rs.getInt("bno"));
				freeboard.setBtitle(rs.getString("btitle"));
				freeboard.setBcontent(rs.getString("bcontent"));
				freeboard.setBwriter(rs.getString("bwriter"));
				freeboard.setBhitcount(rs.getInt("bhitcount"));
				freeboard.setBdate(rs.getDate("bdate"));
				return freeboard;
			}
			
		});
		return (list.size() != 0)?list.get(0):null;
	}
	
	public List<FreeBoard> selectByPage(int pageNo, int rowsPerPage){
		String sql ="";
		sql += "select rn, bno, btitle, bwriter, bhitcount, bdate ";
		sql += "from( ";
		sql += "select rownum as rn, bno, btitle, bwriter, bhitcount, bdate ";
		sql += "from(select bno, btitle, bwriter, bhitcount, bdate from freeboard order by bno desc) ";
		sql += "where rownum<=? ";
		sql += ") ";
		sql += "where rn>=? ";
		List<FreeBoard> list = jdbcTemplate.query(sql, 
				new Object[]{pageNo*rowsPerPage,(pageNo-1)*rowsPerPage+1}, 
				new RowMapper<FreeBoard>(){

					@Override
					public FreeBoard mapRow(ResultSet rs, int row) throws SQLException {
						FreeBoard freeboard = new FreeBoard();
						freeboard.setBno(rs.getInt("bno"));
						freeboard.setBtitle(rs.getString("btitle"));
						freeboard.setBwriter(rs.getString("bwriter"));
						freeboard.setBhitcount(rs.getInt("bhitcount"));
						freeboard.setBdate(rs.getDate("bdate"));
						return freeboard;
					}
			
		});
		return list;
	}
	
	public int count(){
		String sql = "select count(*) from freeboard";
		int count = jdbcTemplate.queryForObject(sql, Integer.class);
		return count;
	}
}












