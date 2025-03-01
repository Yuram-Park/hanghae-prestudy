package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardDto {

	private int board_id;
	private String user_id;
	private String user_nickname;
	private String title;
	private String content;
}
