package com.qk.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Map;

/**
 * Jwt工具类
 */
public class JwtUtils {
    //秘钥
    private static final String SECRET_KEY = "miyao";
    //令牌有效期（1个小时）
    private static final long EXPIRATION_TIME =  60 * 1000;

    /**
     * 生成令牌
     * @param claims
     * @return
     */
    public static String generateToken(Map<String,Object> claims){
        String token = Jwts.builder()
                .addClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
        return token;
    }

    /**
     * 解析Jwt令牌
     * @param token
     * @return
     */
    public static Claims parseToken(String token) {
        Claims claims = Jwts.parser()
                .parseClaimsJwt(token)
                .getBody();
        return claims;
    }
}
