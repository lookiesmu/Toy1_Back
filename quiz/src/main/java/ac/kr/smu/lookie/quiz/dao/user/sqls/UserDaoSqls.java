package ac.kr.smu.lookie.quiz.dao.user.sqls;

public class UserDaoSqls {
    public static final String SELECT_USER_BY_NICKNAME = "SELECT user_id, nickname, password, quiz_create " +
                                                         "FROM user " +
                                                         "WHERE nickname = :nickname";

    public static final String DELETE_USER = "DELETE " +
                                             "FROM user " +
                                             "WHERE nickname = :nickname";

    public static final String UPDATE_NICKNAME = "UPDATE user " +
                                                 "SET nickname = :newNickname " +
                                                 "WHERE nickname = :nickname";
}