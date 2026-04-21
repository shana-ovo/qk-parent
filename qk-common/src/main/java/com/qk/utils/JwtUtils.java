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
    private static final String SECRET_KEY = "huangshiyu";
    //令牌有效期（12个小时）
    private static final long EXPIRATION_TIME = 12 * 60 * 60 * 1000;

    /**
     * 生成令牌
     * @param claims
     * @return
     */
    public static String generateToken(Map<String,Object> claims){
        String token = Jwts.builder()
                .setClaims(claims)
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
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)  //*** 注意是  *Jws* 不是Jwt，Jwt会无法解析
                .getBody();
        return claims;
    }
}
