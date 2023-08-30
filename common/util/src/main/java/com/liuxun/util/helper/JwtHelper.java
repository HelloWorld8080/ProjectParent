package com.liuxun.util.helper;

import com.liuxun.model.user.UserVo;
import io.jsonwebtoken.*;
import org.springframework.util.StringUtils;

import java.util.Date;

public class JwtHelper {

    //过期时间
    private static long tokenExpiration = 20*24*60*60*1000;
    //签名秘钥
    private static String tokenSignKey = "123456";

    //根据参数生成token
    public static String createToken(UserVo userVo) {
        String token = Jwts.builder()
                .setSubject("MAIL-RBDA")
                .setExpiration(new Date(System.currentTimeMillis() + tokenExpiration))
                .claim("phone", userVo.getPhone())
                .signWith(SignatureAlgorithm.HS512, userVo.getCode())
                .compressWith(CompressionCodecs.GZIP)
                .compact();
        return token;
    }

    //根据token字符串得到用户id
    public static String getPhone(String token) {
        if(StringUtils.isEmpty(token)) return null;

        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(tokenSignKey).parseClaimsJws(token);
        Claims claims = claimsJws.getBody();
        return (String)claims.get("phone");
    }

    //根据token字符串得到用户名称
    public static String getCode(String token) {
        if(StringUtils.isEmpty(token)) return "";

        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(tokenSignKey).parseClaimsJws(token);
        Claims claims = claimsJws.getBody();
        return (String)claims.get("code");
    }

    public static void main(String[] args) {
        UserVo userVo = new UserVo();
        userVo.setCode("123456");
        userVo.setPhone("17864234909");
        String token = JwtHelper.createToken(userVo);
        getCode(token);
    }
}

