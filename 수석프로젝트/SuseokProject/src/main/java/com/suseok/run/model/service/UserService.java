package com.suseok.run.model.service;

import com.suseok.run.model.dto.Condition;
import com.suseok.run.model.dto.User;

public interface UserService {

	User search(Condition con);

	boolean insert(User user);

}
