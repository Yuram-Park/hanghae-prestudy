package com.example.demo.dto;

import com.example.demo.entity.Board;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardResponseDto {

	private int board_id;
	private String user_id;
	private String urser_nickname;
	private String title;
	private String content;
	
	public BoardResponseDto(Board board) {
		this.board_id = board.getBoardId();
		this.user_id = board.getUserId();
		this.title = board.getTitle();
		this.content = board.getContent();
	}
	
}
