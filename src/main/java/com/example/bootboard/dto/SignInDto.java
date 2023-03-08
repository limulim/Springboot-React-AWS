package com.example.bootboard.dto;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignInDto {
	@NotBlank
	private String UserEmail;
	@NotBlank
	private String UserPassword;
	
	
}
