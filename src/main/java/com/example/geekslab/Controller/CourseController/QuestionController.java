package com.example.geekslab.Controller.CourseController;
import com.example.geekslab.Entites.Question;
import com.example.geekslab.IService.ICourseService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/questions")
public class QuestionController {

    private final ICourseService courseService;

    public QuestionController(ICourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public List<Question> findAll() {
        return courseService.findAllQuestions();
    }

    @GetMapping("/{id}")
    public Question findById(@PathVariable Long id) {
        return courseService.findQuestionById(id);
    }

    @PostMapping
    public Question create(@RequestBody Question question) {
        return courseService.createQuestion(question);
    }

    @PutMapping("/{id}")
    public Question update(@PathVariable Long id, @RequestBody Question question) {
        return courseService.updateQuestion(id, question);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        courseService.deleteQuestion(id);
    }
}
