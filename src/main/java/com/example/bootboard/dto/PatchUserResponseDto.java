package com.example.bootboard.dto;

import com.example.bootboard.entity.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatchUserResponseDto {
	private UserEntity user;
}
