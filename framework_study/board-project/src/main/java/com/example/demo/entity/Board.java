package com.example.demo.entity;

import java.time.LocalDateTime;

import com.example.demo.dto.BoardDto;
import com.example.demo.dto.BoardRequestDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(
		name = "BOARD_ID_SEQ_GENERATOR"
	    , sequenceName = "BOARD_ID_SEQ"
	    , initialValue = 1
	    , allocationSize = 1
	)
public class Board {

	@Id
	@GeneratedValue(
	    	strategy = GenerationType.SEQUENCE
	    	, generator = "BOARD_ID_SEQ_GENERATOR"
	    )
	private Integer boardId;
	
	private String userId;
	
	private LocalDateTime time;
	
	private String title;
	
	private String content;
	
	public Board(BoardRequestDto boardRequestDto) {
		this.userId = boardRequestDto.getUser_id();
		this.title = boardRequestDto.getTitle();
		this.content = boardRequestDto.getContent();
	}
	
	public void update(BoardDto boardDto) {
		this.title = boardDto.getTitle();
		this.content = boardDto.getContent();
	}
}
