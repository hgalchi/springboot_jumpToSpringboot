package com.example.demo.Controller;

import com.example.demo.Entity.Question;
import com.example.demo.Service.QuestionService;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@Controller
@RequestMapping("/question")
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping("/List")
    public ResponseEntity<List<Question>> getList() {

        List<Question> list = questionService.getList();
        return new ResponseEntity<>(list, HttpStatus.OK);

    }


    @GetMapping("/detail/{id}")
    public ResponseEntity<Optional<Question>> getDetail(@PathVariable("id") Integer id) {

        Optional<Question> detail = questionService.getDetail(id);
        return new ResponseEntity<>(detail, HttpStatus.OK);
    }

    @GetMapping("/pageList/{page}")
    public ResponseEntity<Page<Question>> getPage(@PathVariable("page") int page) {
        Page<Question> pagelist = questionService.getPage(page);
        return new ResponseEntity<>(pagelist, HttpStatus.OK);
    }

    @GetMapping("/getResult")
    public ResponseEntity<List<Question>> getResult(@RequestParam String word) {
        List<Question> list = questionService.getResult(word);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
/*
    @PostMapping("getModify")
    public void getModify(@PathVariable Integer id, @RequestParam String )*/

    @PostMapping("exam")
    public ResponseEntity<String> getExam(@RequestParam Map<String, Objects> param) {
        System.out.println(param.get("id"));
        System.out.println(param.get("code"));

        return new ResponseEntity<>("실험", HttpStatus.OK);
    }
}
