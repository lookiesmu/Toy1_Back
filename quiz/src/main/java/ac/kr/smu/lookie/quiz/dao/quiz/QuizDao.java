package ac.kr.smu.lookie.quiz.dao.quiz;

import ac.kr.smu.lookie.quiz.dao.quiz.sqls.QuizSqls;
import ac.kr.smu.lookie.quiz.dto.quiz.Quiz;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class QuizDao {
    private final NamedParameterJdbcTemplate jdbc;
    private final RowMapper<Quiz> QuizRowMapper = BeanPropertyRowMapper.newInstance(Quiz.class);

    public QuizDao(DataSource dataSource){
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
    }

    public List<Quiz> getQuiz(String nickname){
        Map<String, String> params = new HashMap<>();
        params.put("nickname",nickname);
        try{
            return jdbc.query(QuizSqls.READ_QUIZ, params,QuizRowMapper);
        }catch(EmptyResultDataAccessException e){
            return null;
        }
    }

    public List<Quiz> getRandomQuiz(){
        return jdbc.query(QuizSqls.RANDOM_GET_QUIZ, QuizRowMapper);
    }

    public int postQuiz(int quiz_id, int user_id, int answer){
        Map<String, Integer> params = new HashMap<>();
        params.put("quiz_id",quiz_id);
        params.put("user_id",user_id);
        params.put("answer",answer);
        return jdbc.update(QuizSqls.POST_QUIZ, params);
    }
}
