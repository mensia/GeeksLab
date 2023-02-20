package com.example.geekslab.Controller.CourseController;

import com.example.geekslab.Entites.*;
import com.example.geekslab.IService.ICourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/answers")
public class AnswerController {
    private final ICourseService courseService;

    public AnswerController(ICourseService answerService) {
        this.courseService = answerService;
    }

    @GetMapping
    public List<Answer> findAll() {
        return courseService.findAllAnswers();
    }

    @GetMapping("/{id}")
    public Answer findById(@PathVariable Long id) {
        return courseService.findAnswerById(id);
    }

    @PostMapping
    public Answer create(@RequestBody Answer answer) {
        return courseService.createAnswer(answer);
    }

    @PutMapping("/{id}")
    public Answer update(@PathVariable Long id, @RequestBody Answer answer) {
        return courseService.updateAnswer(id, answer);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        courseService.deleteAnswer(id);
    }

    @PostMapping("addAnswerToQuestion/{questionId}/{answerId}")
    public Question addQuestionToQuiz(@PathVariable Long questionId, @PathVariable Long answerId){
        courseService.addAnswerToQuestion(questionId,answerId);
        return courseService.findQuestionById(questionId);
    }
}
