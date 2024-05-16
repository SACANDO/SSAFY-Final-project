package com.suseok.run.jwt;

import java.nio.charset.StandardCharsets;
import java.util.Date;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {

	@Value("${jwt.key}")
	private String jwtKey;

	@Value("${jwt.accesstoken.expiretime}")
	private Long accessTokenExpireTime;

	@Value("${jwt.refreshtoken.expiretime}")
	private Long refreshTokenExpireTime;

	// Access Token 생성 메서드
	public String createAccessToken(String userId) {
		long currentTime = System.currentTimeMillis(); // 현재 시간

		JwtBuilder jwtAccessTokenBuilder = Jwts.builder().claim("userId", userId).setIssuedAt(new Date(currentTime))
				.setExpiration(new Date(currentTime + accessTokenExpireTime * 1000))
				.signWith(SignatureAlgorithm.HS256, jwtKey.getBytes(StandardCharsets.UTF_8));

		return jwtAccessTokenBuilder.compact();
	}

	// Refresh Token 생성 메서드
	public String createRefreshToken(String userId) {
		long currentTime = System.currentTimeMillis(); // 현재 시간

		JwtBuilder jwtRefreshTokenBuilder = Jwts.builder().claim("userId", userId).setIssuedAt(new Date(currentTime))
				.setExpiration(new Date(currentTime + refreshTokenExpireTime * 1000))
				.signWith(SignatureAlgorithm.HS256, jwtKey.getBytes(StandardCharsets.UTF_8));

		return jwtRefreshTokenBuilder.compact();
	}

	public boolean validate(String token) {
		try {
			System.out.println(token);
			Jwts.parser().setSigningKey(jwtKey.getBytes("UTF-8")).parseClaimsJws(token);
		} catch (Exception e) { // token을 파싱하는데 에러가 발생했다면 유효한 토큰이 아님.
			System.out.println(e);
			return false;
		}
		System.out.println("valid");
		return true;
		
//		return Jwts.parser().setSigningKey(jwtKey.getBytes(StandardCharsets.UTF_8)).parseClaimsJws(token);
	}

}
