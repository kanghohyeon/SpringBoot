package com.sist.jwt_0224.jwt;

import java.util.Base64;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtProvider {

    @Value("${custom.jwt.secretKey}")
    private String secretKey;

    private SecretKey sKey;

    public SecretKey getSecretKey() {
        if (sKey == null) { //  이미 생성된 키가 있는 경우 재생성 방지
            String encoding = Base64.getEncoder().encodeToString(secretKey.getBytes());
            sKey = Keys.hmacShaKeyFor(encoding.getBytes()); //  클래스 필드에 할당
        }
        return sKey;
    }

    public String genToken(Map<String, Object> map, int seconds) {
            long now = new Date().getTime();
            Date accesTokenExpiresIn = new Date(now + (seconds * 1000L));
            JwtBuilder jwtBuilder = Jwts.builder().subject("sist").expiration(accesTokenExpiresIn);
            Set<String> keySet = map.keySet(); // 중복 불가능 반복자 처리
            Iterator<String> it = keySet.iterator();
            while (it.hasNext()) {
                String key = it.next();
                Object value= map.get(key);

                jwtBuilder.claim(key, value);

            }
            String jwt = jwtBuilder.signWith(getSecretKey()).compact(); // 위에 함수인 겟시크릿키 함수를 통해 시크릿키를 받아옴
            System.out.println("jwt = " + jwt);
            return jwt;

       
    }
   

    //토큰이 만료되었는지 확인하는 함수를 만들자
    public boolean verify(String token){
        boolean value = true;
        try{
            Jwts.parser().verifyWith(getSecretKey()).build().parseSignedClaims(token);
        }catch(Exception e) {
            //유효기간이 만료될 경우 예외발생
            value = false;
        }

        return value;
    }

    //토큰에 담긴 사용자 정보(claims)를 반환한다.
    public Map<String, Object> getClaims(String token){


        return Jwts.parser().verifyWith(getSecretKey()).build().parseSignedClaims(token).getPayload();
    }


}
