package com.example.bootboard.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bootboard.dto.ResponseDto;
import com.example.bootboard.dto.PatchUserDto;
import com.example.bootboard.dto.PatchUserResponseDto;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@PatchMapping("/")
	public ResponseDto<PatchUserResponseDto> patchUser(
		@RequestBody PatchUserDto requestBody, @AuthenticationPrincipal String userEmail){
		return null;
	}
}
