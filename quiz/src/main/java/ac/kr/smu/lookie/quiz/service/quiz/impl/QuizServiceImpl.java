package ac.kr.smu.lookie.quiz.service.quiz.impl;

import ac.kr.smu.lookie.quiz.dao.quiz.QuizDao;
import ac.kr.smu.lookie.quiz.dto.quiz.Quiz;
import ac.kr.smu.lookie.quiz.service.quiz.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuizServiceImpl implements QuizService {
    @Autowired
    QuizDao quizDao;

    @Override
    public Quiz getQuiz(String nickname){
        return quizDao.getQuiz(nickname);
    }

    @Override
    public Quiz getRandomQuiz(){
        return quizDao.getRandomQuiz();
    }
}
