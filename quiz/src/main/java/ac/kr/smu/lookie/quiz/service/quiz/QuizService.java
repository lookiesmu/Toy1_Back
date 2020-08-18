package ac.kr.smu.lookie.quiz.service.quiz;

import ac.kr.smu.lookie.quiz.dto.quiz.Quiz;

public interface QuizService {
    public Quiz getQuiz(String nickname);
    public Quiz getRandomQuiz();
}
