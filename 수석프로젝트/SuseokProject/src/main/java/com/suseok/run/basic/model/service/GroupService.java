package com.suseok.run.basic.model.service;

import java.util.List;

import com.suseok.run.basic.model.dto.Group;

public interface GroupService {

	//그룹 찾기
	List<Group> search(String con);

	//그룹 생성
	boolean insert(Group group);

	//그룹 가입
	boolean join(int groupId, String userId);

	//그룹 탈퇴
	boolean exit(int groupId, String userId);
	
	//그룹 정보 수정
	boolean update(Group group);

	//멤버 강퇴
	boolean kickOut(int groupId, int memberId);


}
