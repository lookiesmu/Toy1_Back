package ac.kr.smu.lookie.quiz.dao.score;

import ac.kr.smu.lookie.quiz.dao.score.sqls.ScoreSqls;
import ac.kr.smu.lookie.quiz.dto.Score;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ScoreDao {
    private final NamedParameterJdbcTemplate jdbc;
    private final RowMapper<Score> scoreRowMapper = BeanPropertyRowMapper.newInstance(Score.class);
    public ScoreDao(DataSource dataSource){
        this.jdbc= new NamedParameterJdbcTemplate(dataSource);
    }

    public List<Score> selectScoreByExaminer(String examiner){
        Map<String, String> param = new HashMap<>();

        param.put("nickname", examiner);
        return jdbc.query(ScoreSqls.SELECT_ALL_ANSWERER_SCORE_BY_EXAMINER, param, scoreRowMapper);
    }

    public int postScore(int examiner, int answerer, int score){
        Map<String, Integer> params = new HashMap<>();
        params.put("examiner",examiner);
        params.put("answerer",answerer);
        params.put("score",score);
        return jdbc.update(ScoreSqls.POST_SCORE, params);
    }
}
