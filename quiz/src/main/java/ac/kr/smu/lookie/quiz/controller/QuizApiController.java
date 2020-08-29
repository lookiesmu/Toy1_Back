package ac.kr.smu.lookie.quiz.controller;

import ac.kr.smu.lookie.quiz.dto.Score;
import ac.kr.smu.lookie.quiz.dto.quiz.Quiz;
import ac.kr.smu.lookie.quiz.dto.user.User;
import ac.kr.smu.lookie.quiz.dto.user.UserEntity;
import ac.kr.smu.lookie.quiz.service.quiz.QuizService;
import ac.kr.smu.lookie.quiz.service.score.ScoreService;
import ac.kr.smu.lookie.quiz.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/quizzes")
public class QuizApiController {
    @Autowired
    QuizService quizService;

    @Autowired
    UserService userService;

    @Autowired
    ScoreService scoreService;

    @GetMapping(path = "")
    public Map<String, Object> getRandomQuiz(){
        Map<String, Object> map = new HashMap<>();
        try{
            List<Quiz> quiz = quizService.getRandomQuiz();
            map.put("_embedded",quiz);
        } catch (Exception e){
            e.printStackTrace();
        }
        return map;
    }

    @GetMapping(path = "/{nickname}")
    public Map<String, Object> getQuiz(@PathVariable(name = "nickname") String nickname){
        Map<String, Object> map = new HashMap<>();

        try{
            List<Quiz> quiz = quizService.getQuiz(nickname);
            map.put("_embedded",quiz);
        } catch (Exception e){
            e.printStackTrace();
        }
        return map;
    }

    @PostMapping(path = "")
    public Map<String, Object> postQuiz(@RequestParam(name="quiz") List<Quiz> quizs,
                                        @RequestParam(name="user_id") int user_id){
        Map<String, Object> map = new HashMap<>();
        for(Quiz quiz : quizs){
            quizService.postQuiz(quiz.getQuizId(), user_id, quiz.getAnswer());
        }
        map.put("result", "success");
        return map;
    }

    @PostMapping(path = "/{nickname}")
    public Map<String, Object> postScore(@PathVariable(name="nickname") String nickname,
                                         @RequestParam(name="score") Score score_pack){
        Map<String, Object> map = new HashMap<>();
        UserEntity user = userService.selectUser(nickname);
        int examiner = user.getUserId();
        int answerer = score_pack.getUserId();
        int score = score_pack.getScore();

        scoreService.postScore(examiner, answerer, score);
        map.put("result", "success");
        return map;
    }
}
