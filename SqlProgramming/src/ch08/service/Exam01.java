package ch08.service;

import java.util.Date;

import ch08.dao.MemberDao;
import ch08.dto.Member;

public class Exam01 {

	public static void main(String[] args) {
		MemberDao dao = new MemberDao();
		Member member = new Member();
		member.setMid("user8");
		member.setMname("사용자8");
		member.setMage(17);
		member.setMbirth(new Date());
		
		dao.insert(member);
	}

}
