package ac.kr.smu.lookie.quiz.service.score.impl;

import ac.kr.smu.lookie.quiz.dao.score.ScoreDao;
import ac.kr.smu.lookie.quiz.dto.Score;
import ac.kr.smu.lookie.quiz.service.score.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ScoreServiceImpl implements ScoreService {
    @Autowired
    ScoreDao scoreDao;

    @Override
    @Transactional(readOnly = true)
    public List<Score> selectScoreByExaminer(String examiner) {
        return scoreDao.selectScoreByExaminer(examiner);
    }

    @Override
    public int postScore(int examiner, int answerer, int score){
        return scoreDao.postScore(examiner, answerer, score);
    }
}
