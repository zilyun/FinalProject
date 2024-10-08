package com.mbti.finalproject.controller;

import com.mbti.finalproject.domain.inquery.InqueryComment;
import com.mbti.finalproject.service.customer.InqCommentService;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // @Controller + @ResponseBody
@RequestMapping(value = "/inqcomment")
public class InqCommentController {

    private InqCommentService inqCommentService;

    @Autowired
    public InqCommentController(InqCommentService inqCommentService) {
        this.inqCommentService = inqCommentService;
    }

    private static final Logger log = LoggerFactory.getLogger(InqCommentController.class);

    @PostMapping(value = "/add")
    public int CommentAdd(InqueryComment co) {
        log.info("답변 추가");
        return inqCommentService.commentsInsert(co);
    }

    @PostMapping(value = "/reply")
    public int CommentReply(InqueryComment co) {
        log.info("답글 추가");
        return inqCommentService.commentsReply(co);
    }

    @PostMapping(value = "/list")
    public String CommentList(int commentBoardNum, int state) {
        log.info("답변 리스트");
        int listcount = inqCommentService.getListCount(commentBoardNum);

        JsonObject object = new JsonObject();
        object.addProperty("listcount", listcount);

        JsonArray jarray = inqCommentService.getCommentJsonList(commentBoardNum, state);
        JsonElement je = new Gson().toJsonTree(jarray);
        object.add("commentlist", je);
        return object.toString();
    }

    @PostMapping(value = "/update")
    public int CommentUpdate(InqueryComment co) {
        log.info("답변 수정");
        return inqCommentService.commentsUpdate(co);
    }

    @PostMapping(value = "/delete")
    public int CommentDelete(int commNum) {
        log.info("답변 삭제");
        return inqCommentService.commentsDelete(commNum);
    }

}
