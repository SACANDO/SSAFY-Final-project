package com.suseok.run.model.service;

import com.suseok.run.model.dto.Condition;
import com.suseok.run.model.dto.Group;

public interface GroupService {

	Group search(Condition con);

	boolean insert(Group group);

}
