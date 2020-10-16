package com.dmstjd1024.boardrestfulapi.board;

import com.dmstjd1024.boardrestfulapi.board.dto.BoardDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public List<BoardDto> getBoardList(){

        return boardRepository.findAll().stream().map(BoardDto::new).collect(Collectors.toList());
    }

    public BoardDto getBoard(Long id) {

        Board board = boardRepository.findById(id).orElseThrow(NullPointerException::new);

        return new BoardDto(board);
    }

    @Transactional
    public Long updateBoard(Long id, BoardDto boardDto) {

        Board board = boardRepository.findById(id).orElseThrow(NullPointerException::new);

        board.update(boardDto);

        return id;
    }

    public Long createBoard(BoardDto boardDto) {

        Board board = new Board().create(boardDto);

        return board.getId();
    }

    public Long deleteBoard(Long deleteBoardId){

        boardRepository.deleteById(deleteBoardId);

        return deleteBoardId;
    }


}
