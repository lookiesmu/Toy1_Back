package ac.kr.smu.lookie.quiz.service.quiz;

import ac.kr.smu.lookie.quiz.dto.quiz.Quiz;

import java.util.List;

public interface QuizService {
    public List<Quiz> getQuiz(String nickname);
    public List<Quiz> getRandomQuiz();
    public int postQuiz(int quiz_id, int user_id, int answer);
    public int deleteQuiz(int user_id);
}
