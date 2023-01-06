package com.example.demo.Service;


import com.example.demo.Entity.Question;
import com.example.demo.Repository.QuestionRepository;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionRepository questionRepository;

    public List<Question> getList() {

        return questionRepository.findAll();
    }

    public Optional<Question> getDetail(Integer id) {

        return questionRepository.findById(id);
    }

    public Page<Question> getPage(int page) {
        Pageable pageable = PageRequest.of(page, 10);
        return questionRepository.findAll(pageable);
    }

    public List<Question> getResult(String word) {

        return questionRepository.findBySubjectLike("%"+word+"%");
    }

}