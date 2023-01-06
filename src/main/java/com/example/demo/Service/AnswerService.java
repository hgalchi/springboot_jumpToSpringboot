package com.example.demo.Service;

import com.example.demo.Entity.Answer;
import com.example.demo.Entity.Question;
import com.example.demo.Repository.AnswerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AnswerService {
    private final AnswerRepository answerRepository;

    public Answer create(String content, Question q) {
        Answer a=Answer.builder()
                .content(content)
                .createDate(LocalDateTime.now())
                .question(q)
                .build();
        answerRepository.save(a);

        return a;
    }
}
