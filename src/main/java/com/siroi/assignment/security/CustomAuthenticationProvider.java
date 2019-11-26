package com.siroi.assignment.security;

import com.siroi.assignment.dto.UserDTO;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

	private Map<String, UserDTO> userDTOMap = new HashMap<>();

	@PostConstruct
	public void init() {
   		UserDTO userDTO = new UserDTO();
   		userDTO.setRole("ROLE_ADMIN");
   		userDTO.setUserName("ahmed");
   		userDTO.setPassword("password");
   		userDTOMap.put(userDTO.getUserName(), userDTO);
		userDTO = new UserDTO();
		userDTO.setRole("ROLE_USER");
		userDTO.setUserName("mukhtiar");
		userDTO.setPassword("password");
		userDTOMap.put(userDTO.getUserName(), userDTO);
		userDTO = new UserDTO();
		userDTO.setRole("ROLE_ADMIN");
		userDTO.setUserName("admin");
		userDTO.setPassword("password");
		userDTOMap.put(userDTO.getUserName(), userDTO);

	}

	
	@Override
	public Authentication authenticate(Authentication authentication) {
		
		String userName = authentication.getName();
		UserDTO userDTO  = userDTOMap.get(userName);

		if(userDTO != null && userDTO.getPassword().equals(authentication.getCredentials())){
			String role = userDTO.getRole();
           return new UsernamePasswordAuthenticationToken(userDTO, userDTO.getPassword(), Arrays.asList(new SimpleGrantedAuthority(role)));

		} else {
			throw new BadCredentialsException("Invalid username and/or password");
		}
				
		
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(
				UsernamePasswordAuthenticationToken.class);
	}
	

}
