package com.cjh.exam.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjh.exam.demo.repository.MemberRepository;
import com.cjh.exam.demo.util.Utility;
import com.cjh.exam.demo.vo.Member;
import com.cjh.exam.demo.vo.ResultData;

@Service
public class MemberService {
	
	private MemberRepository memberRepository;
	
	@Autowired
	public MemberService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	public ResultData doJoin(String loginId, String loginPw, String name, String nickname, String cellphoneNum,
			String email) {
		
		// 로그인아이디 중복체크
		Member existsMember = getMemberByLoginId(loginId);
		
		if(existsMember != null) {
			return ResultData.from("F-7", Utility.f("아이디(%s)가 이미 존재합니다", loginId));
		}
		
		// 이름 + 이메일 중복체크
		existsMember = getMemberByNameAndEmail(name, email);
		
		if(existsMember != null) {
			return ResultData.from("F-8", Utility.f("이름(%s)과 이메일(%s)가 이미 존재합니다", name,email));
		}
		
		memberRepository.doJoin(loginId, loginPw, name, nickname, cellphoneNum, email);
		ResultData id =memberRepository.getLastInsertId();
		return ResultData.from("S-1", "회원가입이 완료되었습니다", id);
	}

	public Member getMemberById(int id) {
		return memberRepository.getMemberById(id);
	}
	
	private Member getMemberByLoginId(String loginId) {
		return memberRepository.getMemberByLoginId(loginId);
	}
	
	private Member getMemberByNameAndEmail(String name, String email) {
		return memberRepository.getMemberByNameAndEmail(name, email);
	}
	
}