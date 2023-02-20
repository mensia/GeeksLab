package com.example.geekslab.Controller.CourseController;
import com.example.geekslab.Entites.Question;
import com.example.geekslab.IService.ICoursesService.IAnswerService;
import com.example.geekslab.IService.ICoursesService.IQuestionService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/questions")
public class QuestionController {

    private final IQuestionService questionService;
    private final IAnswerService answerService;

    public QuestionController(IQuestionService questionService, IAnswerService answerService) {
        this.questionService = questionService;
        this.answerService = answerService;
    }


    @GetMapping
    public List<Question> findAll() {
        return questionService.findAllQuestions();
    }

    @GetMapping("/{id}")
    public Question findById(@PathVariable Long id) {
        return questionService.findQuestionById(id);
    }

    @PostMapping
    public Question create(@RequestBody Question question) {
        return questionService.createQuestion(question);
    }

    @PutMapping("/{id}")
    public Question update(@PathVariable Long id, @RequestBody Question question) {
        return questionService.updateQuestion(id, question);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        questionService.deleteQuestion(id);
    }

    @PostMapping("addAnswerToQuestion/{questionId}/{answerId}")
    public Question addAnswerToQuestion(@PathVariable Long questionId, @PathVariable Long answerId){
        answerService.addAnswerToQuestion(questionId,answerId);
        return questionService.findQuestionById(questionId);
    }
}
