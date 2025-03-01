package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.BoardDto;
import com.example.demo.dto.BoardRequestDto;
import com.example.demo.dto.BoardResponseDto;
import com.example.demo.service.BoardService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/board")
public class BoardController {

	
	private final BoardService boardService;
	
	@GetMapping("/list")
	public List<BoardResponseDto> getBoardList() {
		
		return boardService.getBoardList();
	}
	
	@PostMapping("/post")
	public String postBoard(@RequestBody BoardRequestDto boardRequestDto) {
		
		boardService.setBoard(boardRequestDto);
		
		return "게시물이 저장되었습니다.";
	}
	
	@PutMapping("/update/{board_id}")
	public String updateBoard(@RequestParam int board_id, @RequestBody BoardDto boardDto) {
		
		boardService.updateBoard(board_id, boardDto);
		return "게시물이 수정되었습니다.";
	}
	
	@DeleteMapping("/delete/{board_id}")
	public String deleteBoard(@RequestParam int board_id) {
		
		return "게시물이 삭제되었습니다.";
	}
}
