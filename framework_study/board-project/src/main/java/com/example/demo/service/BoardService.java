package com.example.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.dto.BoardDto;
import com.example.demo.dto.BoardRequestDto;
import com.example.demo.dto.BoardResponseDto;
import com.example.demo.entity.Board;
import com.example.demo.repository.BoardRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BoardService {
	
	private final BoardRepository boardRepository;

	
	public List<BoardResponseDto> getBoardList() {
		
			List<Board> entityList = boardRepository.findAll();
			
			List<BoardResponseDto> respList = entityList.stream().map(BoardResponseDto::new).collect(Collectors.toList());
			
			return respList;
	}
	
	public String setBoard(BoardRequestDto boardRequestDto) {
		
		Board board = new Board(boardRequestDto);
		
		boardRepository.save(board);
		
		return "성공";
	}
	
	public String updateBoard(int board_id, BoardDto boardDto) {
		
		Board board = boardRepository.findById(board_id).orElseThrow();
		
		board.update(boardDto);
		
		return "수정 완료";
	}
	
	public String deleteBoard(int board_id) {
		boardRepository.deleteById(board_id);
		
		return "삭제 완료";
	}
}
