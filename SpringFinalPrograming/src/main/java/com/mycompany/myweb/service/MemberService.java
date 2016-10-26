package com.mycompany.myweb.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mycompany.myweb.dao.MemberDao;
import com.mycompany.myweb.dto.Member;

@Component
public class MemberService {
	public static final int JOIN_SUCCESS = 0;
	public static final int JOIN_FAIL = 1;
	
	public static final int LOGIN_SUCCESS = 0;
	public static final int LOGIN_FAIL_MID = 1;
	public static final int LOGIN_FAIL_PASSWORD = 2;
	
	public static final int LOGOUT_SUCCESS = 0;
	public static final int LOGOUT_FAIL_MID = 1;
	
	public static final int MODIFY_SUCCESS = 0;
	public static final int MODIFY_FAIL = 1;
	
	public static final int WITHDRAW_SUCCESS = 0;
	public static final int WITHDRAW_FAIL = 1;
	
	@Autowired
	private MemberDao memberDao;
	
	//정상 OR 예외 -> void
	public int join(Member member){
		memberDao.insert(member);
		return JOIN_SUCCESS;
	}
	
	public int login(String mid, String mpassword,HttpSession session){
		Member member = memberDao.selectByMid(mid);
		if(member == null) {return LOGIN_FAIL_MID;}
		if(member.getMpassword().equals(mpassword) == false){return LOGIN_FAIL_PASSWORD;}
		session.setAttribute("login", mid);
		return LOGIN_SUCCESS;
	}
	//정상 OR 예외 -> void
	//세션에 로그인 정보 저장되어 있으므로 그냥 지우면 됨
	public int logout(HttpSession session){
		session.removeAttribute("login");
		return LOGOUT_SUCCESS;
	}
	
	public String findPassword(String mid, String memail){
		Member member = memberDao.selectByMid(mid);
		if(member == null){return null;}
		if(member.getMemail().equals(memail) == false){return null;}
		return member.getMpassword();
	}
	
	public String findMid(String memail){
		return memberDao.selectByMemail(memail);
	}
	
	public Member info(String mpassword,HttpSession session){
		String mid = (String) session.getAttribute("login");
		Member member = memberDao.selectByMid(mid);
		if(member.getMpassword().equals(mpassword) == false){return null;}
		return member;
	}
	
	public int modify(Member member){
		memberDao.update(member);
		return MODIFY_SUCCESS;
	}
	
	public int withdraw(String mpassword,HttpSession session){
		String mid = (String)session.getAttribute("login");
		Member member = memberDao.selectByMid(mid);
		if(member.getMpassword().equals(mpassword) == false){return WITHDRAW_FAIL;}
		memberDao.delete(mid);
		//session.removeAttribute("login");
		logout(session);
		return WITHDRAW_SUCCESS;
	}
	
	public boolean isMid(String mid){
		Member member = memberDao.selectByMid(mid);
		if(member.getMid().equals(mid) == false){return false;}
		return true;
	}
}
