package com.example.bootboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.bootboard.dto.ResponseDto;
import com.example.bootboard.dto.SignInDto;
import com.example.bootboard.dto.SignInResponseDto;
import com.example.bootboard.dto.SignUpDto;
import com.example.bootboard.entity.UserEntity;
import com.example.bootboard.repository.UserRepository;
import com.example.bootboard.security.TokenProvider;

@Service
public class AuthService {
	
	@Autowired UserRepository userRepository;
	@Autowired TokenProvider tokenProvider;

	private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();	
	public ResponseDto<?> signUp(SignUpDto dto) {
		String userEmail = dto.getUserEmail();
		String userPassword = dto.getUserPassword();
		String userPassWordCheck = dto.getUserPasswordCheck();
		try {
			if(userRepository.existsById(userEmail))
				return ResponseDto.setFailed("Existed Email");
			
		}catch (Exception e) {
			return ResponseDto.setFailed("Data Base Error!");
		}
		
		if (!userPassword.equals(userPassWordCheck))
			return ResponseDto.setFailed("Password does not matched!");
	
		UserEntity userEntity = new UserEntity(dto);
	
		String encodedPassword = passwordEncoder.encode(userPassword);
		userEntity.setUserPassword(passwordEncoder.encode(userPassWordCheck));
		
		try {
		userRepository.save(userEntity);
	} catch(Exception error) {
		return ResponseDto.setFailed("Data Base Error");
	}
		return ResponseDto.setSuccess("Sign Up Success!", null);
	}

	public ResponseDto<SignInResponseDto> signIn(SignInDto dto) {
		String userEmail = dto.getUserEmail();
		String userPassword = dto.getUserPassword();
		
		UserEntity userEntity = null;
		try {
			userEntity = userRepository.findByUserEmail(userEmail);
			if(userEntity == null) return ResponseDto.setFailed("Sign In failed");
			if(!passwordEncoder.matches(userPassword, userEntity.getUserPassword()))
				return ResponseDto.setFailed("Sign In failed");
		}catch(Exception error){
			return ResponseDto.setFailed("Database error");
		}
		
			userEntity.setUserPassword("");
			
			String token = tokenProvider.create(userEmail);
			int exprTime = 360000;
			 
			SignInResponseDto signInResponseDto = new SignInResponseDto(token, exprTime, userEntity);
			return ResponseDto.setSuccess("sign IN Success", signInResponseDto);
	}
}
