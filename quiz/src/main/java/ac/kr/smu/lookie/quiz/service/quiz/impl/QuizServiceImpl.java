package ac.kr.smu.lookie.quiz.service.quiz.impl;

import ac.kr.smu.lookie.quiz.dao.quiz.QuizDao;
import ac.kr.smu.lookie.quiz.dto.quiz.Quiz;
import ac.kr.smu.lookie.quiz.service.quiz.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizServiceImpl implements QuizService {
    @Autowired
    QuizDao quizDao;

    @Override
    public List<Quiz> getQuiz(String nickname){
        return quizDao.getQuiz(nickname);
    }

    @Override
    public List<Quiz> getRandomQuiz(){
        return quizDao.getRandomQuiz();
    }

    @Override
    public int postQuiz(int quiz_id, int user_id, int answer){
        return quizDao.postQuiz(quiz_id,user_id,answer);
    }

    @Override
    public int deleteQuiz(int user_id){
        return quizDao.deleteQuiz(user_id);
    }
}
