package com.example.demo;

import com.example.demo.Entity.Question;
import com.example.demo.Repository.QuestionRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
class JumpToApplicationTests {

	@Autowired
	private QuestionRepository questionRepository;

	@Test
	public void QuestionCreate(){
		Question q1 = Question.builder()
				.subject("db연관관계")
				.content("논리적,문리적 설계란?")
				.createDate(LocalDateTime.now())
				.build();
		this.questionRepository.save(q1);

		Question q2 = Question.builder()
				.subject("bean자동 주입이란?")
				.content("autowired어노테이션이하는 역학")
				.createDate(LocalDateTime.now())
				.build();
		this.questionRepository.save(q2);

	}

	@Test
	public void 테스트(){
		for (int i = 0; i < 100; i++) {
			questionRepository.save(Question.builder().subject("test").content("테스트중").createDate(LocalDateTime.now()).build());

		}
	}


	@Test
	@Transactional
	public void QuestionFindAll(){
		List<Question> list=questionRepository.findAll();
		System.out.println(list.get(0).getAnswer());
	}

	@Test
	public void 검색결과페이징처리(){

	}

}
