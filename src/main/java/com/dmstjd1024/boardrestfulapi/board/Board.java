package com.dmstjd1024.boardrestfulapi.board;

import com.dmstjd1024.boardrestfulapi.board.dto.BoardDto;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board {

    @Id @GeneratedValue
    private Long id;

    private String title;

    private String content;

    private LocalDateTime createDate;

    private LocalDateTime modifyDate;

    private Long boardViewCheck;

    private Long boardRecommend;

    public Board create(BoardDto boardDto){

        Board board = Board.builder()
                .title(boardDto.getTitle())
                .content(boardDto.getContent())
                .createDate(LocalDateTime.now())
                .modifyDate(LocalDateTime.now())
                .boardViewCheck(0L)
                .boardRecommend(0L)
                .build();

        return board;

    }
    public void update(BoardDto boardDto) {
        this.title = boardDto.getTitle();
        this.modifyDate = LocalDateTime.now();
        this.content = boardDto.getContent();
    }
}
