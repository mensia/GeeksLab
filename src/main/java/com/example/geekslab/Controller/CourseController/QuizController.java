package com.example.geekslab.Controller.CourseController;

import com.example.geekslab.Entites.Quiz;
import com.example.geekslab.IService.ICoursesService.IQuizService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quizzes")
public class QuizController {

    private final IQuizService quizService;

    public QuizController(IQuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping
    public List<Quiz> findAll() {
        return quizService.findAllQuizzes();
    }

    @GetMapping("/{id}")
    public Quiz findById(@PathVariable Long id) {
        return quizService.findQuizById(id);
    }

    @PostMapping
    public Quiz create(@RequestBody Quiz quiz) {
        return quizService.createQuiz(quiz);
    }

    @PutMapping("/{id}")
    public Quiz update(@PathVariable Long id, @RequestBody Quiz quiz) {
        return quizService.updateQuiz(id, quiz);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        quizService.deleteQuiz(id);
    }


    @PostMapping("addQuestionToQuiz/{quizId}/{questionId}")
    public Quiz addQuestionToQuiz( @PathVariable Long quizId, @PathVariable Long questionId){
        quizService.addQuestionToQuiz(quizId,questionId);
        return quizService.findQuizById(quizId);
    }

}