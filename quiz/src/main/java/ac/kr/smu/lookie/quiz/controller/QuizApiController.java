package ac.kr.smu.lookie.quiz.controller;

import ac.kr.smu.lookie.quiz.dto.quiz.Quiz;
import ac.kr.smu.lookie.quiz.service.quiz.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping(path = "/quizzes")
public class QuizApiController {
    @Autowired
    QuizService quizService;

    @GetMapping(path = "")
    public Map<String, Object> getRandomQuiz(){
        Map<String, Object> map = new LinkedHashMap<>();
        try{
            Quiz quiz = quizService.getRandomQuiz();
            map.put("_embedded",quiz);
        } catch (Exception e){
            e.printStackTrace();
        }
        return map;
    }

    @GetMapping(path = "/{nickname}")
    public Map<String, Object> getQuiz(@PathVariable(name = "nickname") String nickname){
        Map<String, Object> map = new LinkedHashMap<>();

        try{
            Quiz quiz = quizService.getQuiz(nickname);
            map.put("_embedded",quiz);
        } catch (Exception e){
            e.printStackTrace();
        }
        return map;
    }
}
