package com.example.bootboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bootboard.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {

	public boolean existsByUserEmailAndUserPassword(String userEmail, String userPAssword);

	public UserEntity findByUserEmail(String userEmail);
}
