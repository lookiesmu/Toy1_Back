package ac.kr.smu.lookie.quiz.dao.quiz;

import ac.kr.smu.lookie.quiz.dao.quiz.sqls.QuizSqls;
import ac.kr.smu.lookie.quiz.dao.user.sqls.UserDaoSqls;
import ac.kr.smu.lookie.quiz.dto.quiz.Quiz;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.Map;

@Repository
public class QuizDao {
    private final NamedParameterJdbcTemplate jdbc;
    private final RowMapper<Quiz> userRowMapper = BeanPropertyRowMapper.newInstance(Quiz.class);

    public QuizDao(DataSource dataSource){
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
    }

    public Quiz getQuiz(String nickname){
        Map<String, String> params = Collections.singletonMap("nickname", nickname);
        try{
            return jdbc.queryForObject(QuizSqls.READ_QUIZ, params, userRowMapper);
        }catch(EmptyResultDataAccessException e){
            return null;
        }
    }

    public Quiz getRandomQuiz(){
        return (Quiz) jdbc.query(QuizSqls.RANDOM_GET_QUIZ, userRowMapper);
    }
}
