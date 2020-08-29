package ac.kr.smu.lookie.quiz.service.score;

import ac.kr.smu.lookie.quiz.dto.Score;

import java.util.List;

public interface ScoreService {
    public List<Score> selectScoreByExaminer(String examiner);
    public int postScore(int examiner, int answerer, int score);
}
