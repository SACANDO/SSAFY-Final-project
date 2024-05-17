package com.suseok.run.basic.model.dao;

import com.suseok.run.basic.model.dto.JwtToken;

public interface JwtDao {
	
	boolean insert(JwtToken jwtToken);

	boolean deleteRefreshToken(String userId);
}
