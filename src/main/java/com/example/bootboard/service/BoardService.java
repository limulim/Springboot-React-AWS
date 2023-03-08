package com.example.bootboard.service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bootboard.dto.ResponseDto;
import com.example.bootboard.entity.BoardEntity;
import com.example.bootboard.entity.PopularSearchEntity;
import com.example.bootboard.repository.BoardRepository;
import com.example.bootboard.repository.PopularSearchRepository;

@Service
public class BoardService {
	@Autowired BoardRepository boardRepository;
	@Autowired PopularSearchRepository popularSearchRepository;
	
	public ResponseDto<List<BoardEntity>> getTop3(){
		
		List<BoardEntity> boardList = new ArrayList<BoardEntity>();
		Date date = Date.from(Instant.now().minus(7,ChronoUnit.DAYS));
		
		
		try {
			boardList = boardRepository.findTop3ByBoardWriteDateAfterOrderByBoardLikeCountDesc(date);
		}catch(Exception exception){
			exception.printStackTrace();
			return ResponseDto.setFailed("Database Error");
		}
		
		
		return ResponseDto.setSuccess("Success", boardList);
	}

		public ResponseDto<List<BoardEntity>> getList(){
			List<BoardEntity> boardList = new ArrayList<BoardEntity>();
			
			try {
				boardList = boardRepository.findByOrderByBoardWriteDateDesc();
			}catch(Exception exception) {
				exception.printStackTrace();
				return ResponseDto.setFailed("Database error");
			}
			
			
			return ResponseDto.setSuccess("Success", boardList);
		}

		public ResponseDto<List<PopularSearchEntity>> getPopularsearchList(){
			List<PopularSearchEntity> popularSearchList = new ArrayList<PopularSearchEntity>();
			try {
			popularSearchList = popularSearchRepository.findTop10ByOrderByPopularSearchCountDesc();
			}catch(Exception exception){
			exception.printStackTrace();
			return ResponseDto.setFailed("Datebase Error");
			}
			
			return ResponseDto.setSuccess("Success", popularSearchList);
			
		}
		
		public ResponseDto<List<BoardEntity>> getSearchList(String boardTitle) {
			List<BoardEntity> boardList = new ArrayList<BoardEntity>();
			try {
			boardList = boardRepository.findByBoardTitleContains(boardTitle);
			
			}catch(Exception exception) {
				exception.printStackTrace();
				return ResponseDto.setFailed("Database Error");
				
			}
			return ResponseDto.setSuccess("Success", boardList);
		}
}
