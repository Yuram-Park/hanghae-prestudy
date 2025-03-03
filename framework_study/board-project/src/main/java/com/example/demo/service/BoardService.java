package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.dto.BoardRequestDto;
import com.example.demo.dto.BoardResponseDto;
import com.example.demo.entity.Board;
import com.example.demo.repository.BoardRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BoardService {
	
	private final BoardRepository boardRepository;

	
	public List<BoardResponseDto> getBoardList() {
		
			List<Board> entityList = boardRepository.findAll(Sort.by("time"));
			
			List<BoardResponseDto> respList = entityList.stream().map(BoardResponseDto::new).collect(Collectors.toList());
			
			return respList;
	}
	
	public BoardResponseDto getBoardOne(int board_id) {
		Board board = boardRepository.findById(board_id).orElseThrow();
		return new BoardResponseDto(board);
	}
	
	public BoardResponseDto setBoard(BoardRequestDto boardRequestDto) {
		
		Board board = new Board(boardRequestDto);
		board.setTime(LocalDateTime.now());
		
		int id = boardRepository.save(board).getBoardId();
		
		Board savedBoard = boardRepository.findById(id).orElseThrow();
		
		return new BoardResponseDto(savedBoard);
	}
	
	@Transactional
	public String updateBoard(int board_id, BoardRequestDto boardRequestDto) {
		
		Board board = boardRepository.findById(board_id).orElseThrow();
		if(board.getPassword().equals(boardRequestDto.getPassword())) {
			board.update(boardRequestDto);
			return "수정되었습니다.";
		} else {
			return "비밀번호가 일치하지 않습니다.";
		}
		
	}
	
	public String deleteBoard(int board_id, String password) {
		
		Board board = boardRepository.findById(board_id).orElseThrow();
		if(board.getPassword().equals(password)) {
			boardRepository.deleteById(board_id);
		} else {
			return "비밀번호가 일치하지 않습니다.";
		}
		
		return "삭제 완료";
	}
}
