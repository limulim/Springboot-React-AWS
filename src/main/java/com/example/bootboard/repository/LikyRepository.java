package com.example.bootboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bootboard.entity.LikyEntity;

@Repository
public interface LikyRepository extends JpaRepository<LikyEntity, Integer> {

}
