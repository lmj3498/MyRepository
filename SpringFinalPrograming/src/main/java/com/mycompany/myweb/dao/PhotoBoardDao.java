package com.mycompany.myweb.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.mycompany.myweb.dto.PhotoBoard;


@Component
public class PhotoBoardDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public int insert(PhotoBoard photoboard){
		String sql = "insert into photoboard(bno,btitle,bcontent,bwriter,bhitcount,bdate,originalfile,savedfile,mimetype) values(seq_photoboard_bno.nextval,?,?,?,0,sysdate,?,?,?);";
		
		int row = jdbcTemplate.update(
				sql, 
				photoboard.getBtitle(),
				photoboard.getBcontent(),
				photoboard.getBwriter(),
				photoboard.getOriginalfile(),
				photoboard.getSavedfile(),
				photoboard.getMimetype()	
				);
		return row;
	}
	
	public int update(PhotoBoard photoboard){
		String sql = "update photoboard set btitle=?,bcontent=?,bhitcount=?,originalfile=?,savedfile=?,mimetype=? where bno = ?";
		
		int row = jdbcTemplate.update(
				sql, 
				photoboard.getBtitle(),
				photoboard.getBcontent(),
				photoboard.getBhitcount(),
				photoboard.getOriginalfile(),
				photoboard.getSavedfile(),
				photoboard.getMimetype(),
				photoboard.getBno()
				);
		return row;
	}
	
	public int delete(int bno){
		String sql = "delete from photoboard where=?";
		int row = jdbcTemplate.update(sql, bno);
		return row;
		
	}
	
	public PhotoBoard selectByBno(int bno){
		String sql = "select bno,btitle,bcontent,bwriter,bhitcount,bdate,originalfile,savedfile,mimetype from photoboard where = ?";
		List<PhotoBoard> list = jdbcTemplate.query(
				sql, 
				new Object[]{bno}, 
				new RowMapper<PhotoBoard>(){
			@Override
			public PhotoBoard mapRow(ResultSet rs, int row) throws SQLException {
				PhotoBoard photoboard = new PhotoBoard();
				photoboard.setBno(rs.getInt("bno"));
				photoboard.setBtitle(rs.getString("btitle"));
				photoboard.setBcontent(rs.getString("bcontent"));
				photoboard.setBwriter(rs.getString("bwriter"));
				photoboard.setBhitcount(rs.getInt("bhitcount"));
				photoboard.setBdate(rs.getDate("bdate"));
				photoboard.setOriginalfile(rs.getString("originalfile"));
				photoboard.setSavedfile(rs.getString("savedfile"));
				photoboard.setMimetype(rs.getString("mimetype"));
				
				return photoboard;
			}
			
		});
		return (list.size() != 0)?list.get(0):null;
	}
	
	public List<PhotoBoard> selectByPage(int pageNo, int rowsPerPage){
		String sql ="";
		sql += "select rn, bno, btitle, bhitcount, savedfile ";
		sql += "from( ";
		sql += "select rownum as rn, bno, btitle, bhitcount, savedfile ";
		sql += "from(select bno, btitle, bhitcount, savedfile from photoboard order by bno desc) ";
		sql += "where rownum<=? ";
		sql += ") ";
		sql += "where rn>=? ";
		List<PhotoBoard> list = jdbcTemplate.query(
				sql, 
				new Object[]{pageNo*rowsPerPage,(pageNo-1)*rowsPerPage+1}, 
				new RowMapper<PhotoBoard>(){

					@Override
					public PhotoBoard mapRow(ResultSet rs, int row) throws SQLException {
						PhotoBoard photoboard = new PhotoBoard();
						photoboard.setBno(rs.getInt("bno"));
						photoboard.setBtitle(rs.getString("btitle"));
						photoboard.setBhitcount(rs.getInt("bhitcount"));
						photoboard.setSavedfile(rs.getString("savedfile"));
						return photoboard;
					}
			
		});
		return list;
	}
	
	public int count(){
		String sql = "select count(*) from photoboard";
		int count = jdbcTemplate.queryForObject(sql, Integer.class);
		return count;
	}
}
