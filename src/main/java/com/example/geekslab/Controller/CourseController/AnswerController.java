package com.example.geekslab.Controller.CourseController;

import com.example.geekslab.Entites.*;
import com.example.geekslab.IService.ICoursesService.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/answers")
public class AnswerController {
    private final IAnswerService answerService;
    private final IQuestionService questionService;

    public AnswerController(IAnswerService answerService, IQuestionService questionService) {
        this.answerService = answerService;
        this.questionService = questionService;
    }

    @GetMapping
    public List<Answer> findAll() {
        return answerService.findAllAnswers();
    }

    @GetMapping("/{id}")
    public Answer findById(@PathVariable Long id) {
        return answerService.findAnswerById(id);
    }

    @PostMapping
    public Answer create(@RequestBody Answer answer) {
        return answerService.createAnswer(answer);
    }

    @PutMapping("/{id}")
    public Answer update(@PathVariable Long id, @RequestBody Answer answer) {
        return answerService.updateAnswer(id, answer);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        answerService.deleteAnswer(id);
    }


}
