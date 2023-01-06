package com.example.demo.Repository;

import com.example.demo.Entity.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface QuestionRepository extends JpaRepository<Question,Integer> {

    @Override
    Optional<Question> findById(Integer integer);

    Page<Question> findAll(Pageable pageable);

    List<Question> findBySubjectLike(String subject);

    //검색결과를 페이징처리해서 return
    //Page<Question> findBySubjectLike(String subject);

}
