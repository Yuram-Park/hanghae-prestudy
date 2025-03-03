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
	
	@GetMapping("/detail")
	public BoardResponseDto getBoardOne(@RequestParam("board_id") int board_id) {
		return boardService.getBoardOne(board_id);
	}
	
	@PostMapping("/post")
	public BoardResponseDto postBoard(@RequestBody BoardRequestDto boardRequestDto) {
		
		return boardService.setBoard(boardRequestDto);
	}
	
	@PutMapping("/update")
	public String updateBoard(@RequestParam("board_id") int board_id, @RequestBody BoardRequestDto boardRequestDto) {
		
		return boardService.updateBoard(board_id, boardRequestDto);
	}
	
	@DeleteMapping("/delete")
	public String deleteBoard(@RequestParam("board_id") int board_id, @RequestParam("password") String password) {
		return boardService.deleteBoard(board_id, password);
		
	}
}
