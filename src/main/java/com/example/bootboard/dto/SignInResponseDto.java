package com.example.bootboard.dto;

import com.example.bootboard.entity.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor 
@NoArgsConstructor
public class SignInResponseDto {
	private String token;
	private int exprTime;
	private UserEntity user;
}
