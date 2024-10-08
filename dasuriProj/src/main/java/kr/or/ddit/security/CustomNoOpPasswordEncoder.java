package kr.or.ddit.security;

import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomNoOpPasswordEncoder implements PasswordEncoder{

	@Override
	public String encode(CharSequence rawPassword) {
		// 비밀번호를 받아서 인코딩 해주는 메서드
		// but, 아무것도 안하기로 함
		log.info("before encode : "+rawPassword);
		return rawPassword.toString();
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		// 비밀번호를 받은 거랑 DB의 비밀번호랑 비교
		log.warn("matches : "+rawPassword + " < >  "+encodedPassword);
		// 일치 true, 불일치 false
		return rawPassword.toString().equals(encodedPassword);
	}

}
