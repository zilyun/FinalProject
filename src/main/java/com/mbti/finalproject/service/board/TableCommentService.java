package com.mbti.finalproject.service.board;

import com.mbti.finalproject.domain.Board.BoardComment;

import java.util.List;

public interface TableCommentService {

    // 댓글 갯수 구하기
    int getListCount(int board_num);

    List<BoardComment> getCommentList(int boardNum, int page);

    int commentsInsert(BoardComment co);

    int commentsDelete(int num);
}
