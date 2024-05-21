package com.suseok.oauth2.jwt;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Collections;
import java.util.Date;

@Slf4j
@RequiredArgsConstructor
@Component
public class TokenProvider {

    private static final long ACCESS_TOKEN_EXPIRE_TIME_IN_MILLISECONDS = 1000 * 60 * 30; // 30min
    private String secret="your-very-long-secret-key-here-which-is-at-least-32-characters-long";
    private Key key;

    @PostConstruct
    public void init() {
        byte[] key = Decoders.BASE64URL.decode(secret);
        this.key = Keys.hmacShaKeyFor(key);
    }

    public boolean validateToken(String token) {

        try {
            Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token);

            return true;
        } catch (UnsupportedJwtException | MalformedJwtException exception) {
            System.err.println("JWT is not valid");
        } catch (SignatureException exception) {
        	System.err.println("JWT signature validation fails");
        } catch (ExpiredJwtException exception) {
        	System.err.println("JWT is expired");
        } catch (IllegalArgumentException exception) {
        	System.err.println("JWT is null or empty or only whitespace");
        } catch (Exception exception) {
            System.out.println("JWT validation fails");
        }

        return false;
    }

    public String createToken(Authentication authentication) {

        Date date = new Date();
        Date expiryDate = new Date(date.getTime() + ACCESS_TOKEN_EXPIRE_TIME_IN_MILLISECONDS);

        return Jwts.builder()
                .setSubject(authentication.getName())
                .setIssuedAt(date)
                .setExpiration(expiryDate)
                .signWith(key, SignatureAlgorithm.HS512)
                .compact();
    }

    public Authentication getAuthentication(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();

        UserDetails user = new User(claims.getSubject(), "", Collections.emptyList());

        return new UsernamePasswordAuthenticationToken(user, "", Collections.emptyList());
    }
}
