package com.example.geekslab.Controller.CourseController;

import com.example.geekslab.Entites.Quiz;
import com.example.geekslab.IService.ICourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quizzes")
public class QuizController {

    private final ICourseService courseService;

    public QuizController(ICourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public List<Quiz> findAll() {
        return courseService.findAllQuizzes();
    }

    @GetMapping("/{id}")
    public Quiz findById(@PathVariable Long id) {
        return courseService.findQuizById(id);
    }

    @PostMapping
    public Quiz create(@RequestBody Quiz quiz) {
        return courseService.createQuiz(quiz);
    }

    @PutMapping("/{id}")
    public Quiz update(@PathVariable Long id, @RequestBody Quiz quiz) {
        return courseService.updateQuiz(id, quiz);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        courseService.deleteQuiz(id);
    }


    @PostMapping("addQuestionToQuiz/{quizId}/{questionId}")
    public Quiz addQuestionToQuiz( @PathVariable Long quizId, @PathVariable Long questionId){
        courseService.addQuestionToQuiz(quizId,questionId);
        return courseService.findQuizById(quizId);
    }

}