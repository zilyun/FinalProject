package com.mbti.finalproject.controller;

import com.mbti.finalproject.domain.Board.BoardComment;
import com.mbti.finalproject.service.board.TableCommentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value="/comment")
public class CommentController {
    private static final Logger logger = LoggerFactory.getLogger(CommentController.class);

    private TableCommentService CS;

    @Autowired
    public CommentController(TableCommentService CS) {
        this.CS = CS;
    }

    @PostMapping(value = "/list")
    public Map<String, Object> CommentList(int board_num, int page) {
        logger.info("/list : board_num = "+board_num);

        List<BoardComment> list = CS.getCommentList(board_num, page);

        int listcount = CS.getListCount(board_num);
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("list", list);
        map.put("listcount", listcount);
        logger.info("map=" + map.toString());
        logger.info("/comment/list");
        return map;
    }

    @PostMapping(value = "/add")
    public int CommentAdd(BoardComment co) {
        logger.info(co.toString());
        logger.info("등록실행!");
        return CS.commentsInsert(co);
    }

    @PostMapping("/delete")
    public Map<String, Object>  DeleteAction(int bnum, int cnum) {
        Map<String, Object> result = new HashMap<>();
        int deleteresult = CS.commentsDelete(cnum);

        if (deleteresult == 0) {
            result.put("status", "error");
            result.put("message", "삭제 실패");
        } else {
            result.put("status", "success");
            result.put("redirect", "/table/detail?num=" + bnum);
        }

        return result;
    }

}
