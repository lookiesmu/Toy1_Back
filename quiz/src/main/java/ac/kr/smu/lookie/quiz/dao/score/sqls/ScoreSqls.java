package ac.kr.smu.lookie.quiz.dao.score.sqls;

public class ScoreSqls {
    public static final String SELECT_ALL_ANSWERER_SCORE_BY_EXAMINER = "SELECT answerer.user_id, answerer.nickname, answerer.quiz_create, score.score " +
                                                                       "FROM user examiner JOIN score score ON examiner.user_id = score.examiner " +
                                                                                           "JOIN user answerer ON answerer.user_id = score.answerer " +
                                                                       "WHERE examiner.nickname = :nickname " +
                                                                       "ORDER BY score.score DESC";
}
