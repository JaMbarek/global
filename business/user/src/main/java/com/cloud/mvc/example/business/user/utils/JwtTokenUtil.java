package com.cloud.mvc.example.business.user.utils;

import com.google.common.collect.Maps;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Clock;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.DefaultClock;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

@Component
public class JwtTokenUtil implements Serializable {

    private Clock clock = DefaultClock.INSTANCE;

    @Value("${jwt.privateSecret}")
    private String privateSecret;

    @Value("${jwt.expireTime}")
    private Long expireTime;//毫秒

    @Value("${jwt.header}")
    private String header;

    public String generateToken(String username){
        final Date createdDate = clock.now();
        return Jwts.builder()
                .addClaims(Maps.newHashMap())
                .setSubject(username)
                .setIssuedAt(createdDate)
                .setExpiration(generateExpirationDate())
                .signWith(SignatureAlgorithm.HS512, privateSecret)
                .compact();

    }

    public String generateToken(String username, Map<String, Object> claims){
        final Date createdDate = clock.now();
        return Jwts.builder()
                .addClaims(claims)
                .setSubject(username)
                .setIssuedAt(createdDate)
                .setExpiration(generateExpirationDate())
                .signWith(SignatureAlgorithm.HS512, privateSecret)
                .compact();

    }




    public void refresh(String token){
        try {
            final Date createdDate = clock.now();
            final Date expirationDate = generateExpirationDate();
            final Claims claims = (Claims) getClaims(token);
            claims.setIssuedAt(createdDate);
            claims.setExpiration(expirationDate);

            Jwts.builder()
                    .addClaims(claims)
                    .signWith(SignatureAlgorithm.HS512, privateSecret)
                    .compact();
        }catch (Exception e){

        }
    }

    public Map<String, Object> getClaims(String token){
        try {
            return Jwts.parser()
                    .setSigningKey(privateSecret)
                    .setClock(DefaultClock.INSTANCE)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e){
            return null;
        }
    }




    private Date generateExpirationDate() {
        return new Date(System.currentTimeMillis() + expireTime);
    }

    public String getUserName(String token) {
        Claims claims = (Claims) getClaims(token);
        if(claims == null) return null;
        return claims.getSubject();
    }
}
