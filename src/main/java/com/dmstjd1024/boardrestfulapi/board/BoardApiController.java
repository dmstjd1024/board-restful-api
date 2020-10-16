package com.dmstjd1024.boardrestfulapi.board;

import com.dmstjd1024.boardrestfulapi.board.dto.BoardDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/board")
@RequiredArgsConstructor
public class BoardApiController {

    private final BoardService boardService;

    @GetMapping("")
    public ResponseEntity<?> listBoard(){

        List<BoardDto> boardList = boardService.getBoardList();

        return ResponseEntity.ok(boardList);
    }

    @GetMapping("/new")
    public ResponseEntity<?> createViewBoard(BoardDto boardDto){

        return ResponseEntity.ok(boardDto);
    }

    @PostMapping("")
    public ResponseEntity<?> createBoard(BoardDto boardDto){

        Long updateBoardId = boardService.createBoard(boardDto);

        return ResponseEntity.ok(updateBoardId);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> viewBoard(@PathVariable Long id){

        BoardDto board = boardService.getBoard(id);

        return ResponseEntity.ok(board);
    }

    @GetMapping("/{id}/edit")
    public ResponseEntity<?> editBoard(@PathVariable Long id){

        BoardDto board = boardService.getBoard(id);

        return ResponseEntity.ok(board);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateBoard(@PathVariable Long id, @RequestBody BoardDto boardDto){

        Long updateBoardId = boardService.updateBoard(id, boardDto);

        return ResponseEntity.ok(updateBoardId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBoard(@PathVariable Long id){

        Long deleteBoardId = boardService.deleteBoard(id);

        return ResponseEntity.ok(deleteBoardId);
    }


}
