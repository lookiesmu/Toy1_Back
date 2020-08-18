package ac.kr.smu.lookie.quiz.dao.user;

import ac.kr.smu.lookie.quiz.dao.user.sqls.UserDaoSqls;
import ac.kr.smu.lookie.quiz.dto.user.User;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Repository
public class UserDao {
    private final NamedParameterJdbcTemplate jdbc;
    private final RowMapper<User> userRowMapper = BeanPropertyRowMapper.newInstance(User.class);

    private final SimpleJdbcInsert insertAction;

    public UserDao(DataSource dataSource){
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        this.insertAction = new SimpleJdbcInsert(dataSource).withTableName("user").usingGeneratedKeyColumns("user_id");
    }

    public User selectUserByNickname(String nickname){
        Map<String, String> params = Collections.singletonMap("nickname", nickname);
        try{
            return jdbc.queryForObject(UserDaoSqls.SELECT_USER_BY_NICKNAME, params, userRowMapper);
        }catch(EmptyResultDataAccessException e){
            return null;
        }
    }

    public int insertUser(User user){
        SqlParameterSource param = new BeanPropertySqlParameterSource(user);

        return insertAction.executeAndReturnKey(param).intValue();
    }

    public int updateNickname(String nickname, String newNickname){
        Map<String, String> param = new HashMap<>();
        param.put("nickname", nickname);
        param.put("newNickname", newNickname);

        int updateCount = jdbc.update(UserDaoSqls.UPDATE_NICKNAME, param);
        return updateCount;
    }

    public int deleteUserByNickname(String nickname){
        Map<String, String> param = new HashMap<>();
        param.put("nickname", nickname);

        int deleteCount = jdbc.update(UserDaoSqls.DELETE_USER, param);
        return deleteCount;
    }
}
