package com.dmstjd1024.boardrestfulapi.board.dto;

import com.dmstjd1024.boardrestfulapi.board.Board;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoardDto {

    private String title;

    private String content;

    private Long boardViewCheck;

    private Long boardRecommend;

    public BoardDto(Board board){
        this.title = board.getTitle();
        this.content = board.getContent();
        this.boardViewCheck = board.getBoardViewCheck();
        this.boardRecommend = board.getBoardRecommend();
    }
}
