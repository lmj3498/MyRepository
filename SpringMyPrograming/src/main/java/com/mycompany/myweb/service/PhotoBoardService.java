package com.mycompany.myweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.myweb.dao.PhotoBoardDao;
import com.mycompany.myweb.dto.FreeBoard;
import com.mycompany.myweb.dto.PhotoBoard;

@Component
public class PhotoBoardService {

	@Autowired
	private PhotoBoardDao photoBoardDao;
	
	public static final int WRITE_SUCESS = 0;
	public static final int WRITE_FAIL = 1;
	
	public static final int MODIFY_SUCESS = 0;
	public static final int MODIFY_FAIL = 1;
	
	public static final int REMOVE_SUCESS = 0;
	public static final int REMOVE_FAIL = 1;
	
	
	public List<PhotoBoard> list(int pageNo, int rowsPerPage){
		return photoBoardDao.selectByPage(pageNo,rowsPerPage);
	}
	
	public int write(PhotoBoard photoBoard){
		int row = photoBoardDao.insert(photoBoard);
		return WRITE_SUCESS;
	}
	
	public int modify(PhotoBoard photoBoard){
		int row = photoBoardDao.update(photoBoard);
		if(row == 0){return MODIFY_FAIL;}
		return MODIFY_SUCESS;
	}
	
	public int remove(int bno){
		int row = photoBoardDao.delete(bno);
		if(row == 0){return REMOVE_FAIL;}
		return REMOVE_SUCESS;
	}
	
	public PhotoBoard info(int bno){
		return photoBoardDao.selectByBno(bno);
	}

	public int getCount() {
		return photoBoardDao.count();
	}

	
}
