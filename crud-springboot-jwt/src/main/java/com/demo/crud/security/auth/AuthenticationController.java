package com.demo.crud.security.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.crud.models.ResponseInfo;
import com.demo.crud.models.Users;
import com.demo.crud.security.auth.jwt.JwtTokenUtil;
import com.demo.crud.services.UsersService;

/**
 * author: Naimul Hassan
 * 
 * date: 11/19/2024
 */

@RestController
@RequestMapping("api/auth")
public class AuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private UserDetailsServiceImpl userDetailsService;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private UsersService usersService;

	private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);

	@PostMapping("/login")
	public ResponseInfo<String> authenticateUser(@RequestBody AuthenticationRequest authenticationRequest) {
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
				authenticationRequest.getUsername(), authenticationRequest.getPassword()));

		UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		String token = jwtTokenUtil.generateToken(userDetails);
		
		ResponseInfo<String> responseInfo = new ResponseInfo<>();
		
		responseInfo.setStatusCode(HttpStatus.OK.value());
		responseInfo.setMessage("Login Successful!");
		responseInfo.setData(token);

		return responseInfo;
	}

	@PostMapping("/signup")
	public ResponseInfo<Users> registerUser(@RequestBody Users user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));

		return usersService.addUser(user);
	}

}
