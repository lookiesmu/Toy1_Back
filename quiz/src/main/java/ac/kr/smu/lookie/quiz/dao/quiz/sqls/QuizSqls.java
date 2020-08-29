package ac.kr.smu.lookie.quiz.dao.quiz.sqls;

public class QuizSqls {
    public static final String READ_QUIZ = "SELECT q.quiz_id, q.content, uq.answer " +
            "FROM quiz q, user_quiz uq, user u "+
            "WHERE uq.quiz_id=q.quiz_id AND uq.user_id=u.user_id AND u.nickname = :nickname";

    public static final String RANDOM_GET_QUIZ = "SELECT distinct(q.quiz_id), q.content, uq.answer " +
            "FROM quiz q, user_quiz uq, user u " +
            "ORDER BY RAND() limit 5";

    public static final String POST_QUIZ = "INSERT INTO user_quiz(quiz_id, user_id, answer) " +
            "VALUES(:quiz_id, :user_id, :answer)";

    public static final String DELETE_QUIZ = "DELETE FROM user_quiz " +
            "WHERE user_quiz.user_id = :user_id";

}
