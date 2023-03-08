package com.example.bootboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bootboard.dto.ResponseDto;
import com.example.bootboard.dto.SignInDto;
import com.example.bootboard.dto.SignInResponseDto;
import com.example.bootboard.dto.SignUpDto;
import com.example.bootboard.service.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	@Autowired AuthService authService;
	
	@PostMapping("/signUp")
	public ResponseDto<?> signUp(@RequestBody SignUpDto requestBody){
		ResponseDto<?> result = authService.signUp(requestBody);
		return result;
	}


	@PostMapping("/signIn")
	public ResponseDto<SignInResponseDto> signIn(@RequestBody SignInDto requestBody) {
		ResponseDto<SignInResponseDto> result = authService.signIn(requestBody);
		return result;
	}

}
