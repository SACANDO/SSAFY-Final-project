package com.suseok.run.basic.model.dao;

import com.suseok.run.basic.model.dto.JwtDto;

public interface JwtDao {
	
	boolean insert(JwtDto jwtDto);

	boolean deleteRefreshToken(String userId);
}
