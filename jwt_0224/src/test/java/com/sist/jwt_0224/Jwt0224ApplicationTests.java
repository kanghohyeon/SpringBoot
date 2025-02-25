package com.sist.jwt_0224;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import com.sist.jwt_0224.jwt.JwtProvider;

import io.jsonwebtoken.security.Keys;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.SecretKey;

@SpringBootTest
class Jwt0224ApplicationTests {

	@Value("${custom.jwt.secretKey}")
	private String secretKey;

	@Test
	@DisplayName("시크릿 키 로드 테스트")
	void loadSecretKey() {
		assertThat(secretKey).isNotNull();
	}

	@Test
	@DisplayName("암호화 알고리즘으로 시크릿 key 암호화")
	void genBase64() {
		String encoding = Base64.getEncoder().encodeToString(secretKey.getBytes());
		System.out.println("encoding = " + encoding);
		SecretKey sKey = Keys.hmacShaKeyFor(encoding.getBytes());
		assertThat(sKey).isNotNull();
	}

	@Autowired
	private JwtProvider jwtProvider;

	@Test
	@DisplayName("JwtProvider 를 통해 secretKey를 얻을 수 있냐냐")
	void testJwtProvider() {
		SecretKey sKey = jwtProvider.getSecretKey();
		assertThat(sKey).isNotNull();
	}

	@Test
	@DisplayName("동일한 secretKey인지 확인")
	void sameSecretKey() {
		SecretKey sKey1 = jwtProvider.getSecretKey();
		SecretKey sKey2 = jwtProvider.getSecretKey();
		assertThat(sKey1==sKey2).isTrue();

}

	@Test
	@DisplayName("토큰 생성 테스트")
	void genToken() {
		Map<String, Object> claims = new HashMap<>();
		claims.put("id", 1L);
		claims.put("name", "마루치");
		claims.put("email", "maru@korea.com");

		String accessToken = jwtProvider.genToken(claims, 60*60*3);
		assertThat(accessToken).isNotNull();

		System.out.println("accessToken = " + accessToken);//https://jwt.io/

	}


	@Test
	@DisplayName("유효한 토큰인지? 만료여부 확인 함수")
	void TokenValidTest() {
		Map<String, Object> claims = new HashMap<>();
		claims.put("id", 1L);
		claims.put("name", "마루치");
		claims.put("email", "maru@korea.com");

		String accessToken = jwtProvider.genToken(claims, -1);//만료료
		assertThat(jwtProvider.verify(accessToken)).isFalse();


	}

	@Test
	@DisplayName("Token에서 사용자 정보(claims)를 확인")
	void TokenclaimsTest() {
		Map<String, Object> claims = new HashMap<>();
		claims.put("id", 1L);
		claims.put("name", "이루치");
		claims.put("email", "2ru@korea.com");

		String accessToken = jwtProvider.genToken(claims, 60*60);//만료료
		assertThat(jwtProvider.verify(accessToken)).isTrue();

		//토큰에 저장되어 있는 정보를 확인
		Map<String, Object> map = jwtProvider.getClaims(accessToken);
		System.out.println("map = " + map);
		assertThat(map.get("name")).isEqualTo("이루치");


	}
}