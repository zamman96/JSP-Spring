package kr.or.ddit.security;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import kr.or.ddit.mapper.EmpMapper;
import kr.or.ddit.vo.EmpVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Inject
	EmpMapper empMapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//MVC에서는 Controller로 리턴하지 않고, CustomUser로 리턴함
	      //CustomUser : 사용자 정의 유저 정보. extends User를 상속받고 있음
	      //2) 스프링 시큐리티의 User 객체의 정보로 넣어줌 => 프링이가 이제부터 해당 유저를 관리
	      //User : 스프링 시큐리에서 제공해주는 사용자 정보 클래스
	      /*
	       memberVO(우리) -> user(시큐리티)
	       -----------------
	       userId        -> username
	       userPw        -> password
	       enabled       -> enabled
	       memberAuthVoList               -> authorities
	       */
		EmpVO empVO=this.empMapper.getLogin(username);
		log.info("empVO >>"+empVO);
		
		return empVO == null?null:new CustomUser(empVO);
	}

}
