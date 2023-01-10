package com.example.demo.Controller;

import com.example.demo.Entity.Answer;
import com.example.demo.Entity.Question;
import com.example.demo.Service.AnswerService;
import com.example.demo.Service.QuestionService;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/answer")
@RequiredArgsConstructor

public class AnswerController {
    private final AnswerService answerService;
    private final QuestionService questionService;

    //답변생성 id=답변의 질문id
    @PostMapping("/create/{id}")
    public ResponseEntity<Answer> create(@PathVariable("id") Integer id
            , @RequestParam(required = false, defaultValue = "answer about question") String content) {

        Question q = questionService.getList().get(id);
        Answer a = answerService.create(content, q);

        return new ResponseEntity<>(a, HttpStatus.OK);

    }

    @PostMapping("test/{num}")
    @ResponseBody
    public String test(@PathVariable int num, @RequestParam(required = false, defaultValue = "answer about question") String content) {
        System.out.println(num);
        return content;
    }
}
