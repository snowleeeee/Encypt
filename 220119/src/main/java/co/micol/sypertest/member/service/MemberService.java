package co.micol.sypertest.member.service;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface MemberService {
	
	List<MemberVO> memberSelectList();
	MemberVO memberSelect(MemberVO vo);//한명 조회 + 로그인 처리
	int memberInsert(MemberVO vo);
	int memberUpdate(MemberVO vo);
	int memberDelete(MemberVO vo);
	
}
