package com.cjh.exam.demo.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public class ReplyRepository {

	@Insert("""
			INSERT INTO reply
			SET regDate=NOW(),
			updateDate=NOW(),
			memberId=#{loginedMemberId}
			relTypeCod=#{relTypeCode},
			relId=#{relId},
			`body`=#{body}
			""")
	void writeReply(int loginedMemberId,String relTypeCode,int relId,String body) {
		
	}
}
