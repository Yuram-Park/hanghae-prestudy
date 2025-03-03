package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardRequestDto {

	private String user_id;
	private String password;
	private String title;
	private String content;
}
