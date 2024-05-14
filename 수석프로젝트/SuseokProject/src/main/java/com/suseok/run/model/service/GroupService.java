package com.suseok.run.model.service;

import com.suseok.run.model.dto.Condition;
import com.suseok.run.model.dto.Group;

public interface GroupService {

	Group search(Condition con);

	boolean insert(Group group);

	boolean join(int groupId, String userId);

	boolean exit(int groupId, String userId);

	boolean update(Group group);


}
