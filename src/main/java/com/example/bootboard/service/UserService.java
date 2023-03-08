package com.example.bootboard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bootboard.dto.PatchUserDto;
import com.example.bootboard.dto.PatchUserResponseDto;
import com.example.bootboard.dto.ResponseDto;
import com.example.bootboard.entity.UserEntity;
import com.example.bootboard.repository.UserRepository;

@Service
public class UserService {

	@Autowired UserRepository userRepository; 

	public ResponseDto<PatchUserResponseDto> patchUser(PatchUserDto dto,  String userEmail) {
		UserEntity userEntity = null;
		String userNickname = dto.getUserNickname();
		String userProfile = dto.getUserProfile();
		try {
			userEntity = userRepository.findByUserEmail(userEmail);
			if(userEntity == null)  
				return ResponseDto.setFailed("Does Not Exist User");
			
			userEntity.setUserNickname(userNickname);
			userEntity.setUserProfile(userProfile);
	
			userRepository.save(userEntity);
		}catch(Exception exception) {
			exception.printStackTrace();
			return ResponseDto.setFailed("DataBase Error");
		}
		userEntity.setUserPassword("");
		
		PatchUserResponseDto patchUserResponseDto = new PatchUserResponseDto(userEntity);
		return ResponseDto.setSuccess("Success", patchUserResponseDto);
	}
}
