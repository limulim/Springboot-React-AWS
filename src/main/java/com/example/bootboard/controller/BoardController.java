package com.example.bootboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bootboard.dto.ResponseDto;
import com.example.bootboard.entity.BoardEntity;
import com.example.bootboard.entity.PopularSearchEntity;
import com.example.bootboard.service.BoardService;

@RestController
@RequestMapping("/api/board")
public class BoardController {

	@Autowired BoardService boardService;
	
	@GetMapping("/top3")
	public ResponseDto<List<BoardEntity>> getTop3() {
		return boardService.getTop3();
	}
	
	@GetMapping("/list")
	public ResponseDto<List<BoardEntity>> getList() {
		return boardService.getList();
	}

	@GetMapping("/popularsearchList") 
	public ResponseDto<List<PopularSearchEntity>> getPopularsearchList(){
		return boardService.getPopularsearchList();
	}

	@GetMapping("/search/{title}")
	public ResponseDto<List<BoardEntity>> getSearchList(@PathVariable("boardtitle") String title) {
		return null;
	}


}
