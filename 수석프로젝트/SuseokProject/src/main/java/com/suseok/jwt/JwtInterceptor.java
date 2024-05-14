package com.suseok.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtInterceptor implements HandlerInterceptor{
	private final String HEADER_AUTH = "access-token";
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		
		if(!(handler instanceof HandlerMethod)) {
			return true;
		}
		
		HandlerMethod method = (HandlerMethod) handler;
		
		// @AuthRequired가 붙어있는 메서드라면 
		if(method.getMethodAnnotation(JwtRequired.class) != null) {

			// 그 외 나머지 요청(토큰이 있는 상태로 와야)
			// request 객체에서 요청 헤더를 꺼내서 확인.
			String accessToken = request.getHeader("Authorization");
			System.out.println(accessToken);
			
			if(accessToken != null) {
				if(jwtUtil.validate(accessToken)) { // 유효한 토큰이라면
					
//					Jws<Claims> claims =  jwtUtil.validate(accessToken);
//					request.setAttribute("claims", claims);
//					System.out.println(claims.getBody());
					System.out.println("interceptor: valid");
					return true; // 요청을 계속진행.
				}
			}
			System.out.println("interceptor: invalid");
			response.setStatus(HttpStatus.UNAUTHORIZED.value());
			return false; // 요청을 중지.
		}
		return true; // @AuthRequired가 붙어있지 않다면 그냥 통과
	}
	
}
