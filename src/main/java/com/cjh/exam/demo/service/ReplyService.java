package com.cjh.exam.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjh.exam.demo.repository.ReplyRepository;
import com.cjh.exam.demo.util.Utility;
import com.cjh.exam.demo.vo.Reply;
import com.cjh.exam.demo.vo.ResultData;

@Service
public class ReplyService {
	
	private ReplyRepository replyRepository;

	@Autowired
	public ReplyService(ReplyRepository replyRepository) {
		this.replyRepository = replyRepository;
	}

	public ResultData<Integer> writeReply(int loginedMemberId, String relTypeCode, int relId, String body) {
		replyRepository.writeReply(loginedMemberId, relTypeCode, relId, body);
		int id = replyRepository.getLastInsertId();
		return ResultData.from("S-1", Utility.f("%d번 댓글이 생성되었습니다", id), "id", id);
	}

	public List<Reply> getForPrintReplies(String relTypeCode, int id) {
		return replyRepository.getForPrintReplies(relTypeCode, id);
	}
}