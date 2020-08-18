package ac.kr.smu.lookie.quiz.dao.quiz.sqls;

public class QuizSqls {
    public static final String READ_QUIZ = "SELECT q.quiz_id, q.content, uq.answer " +
            "FROM quiz q, user_quiz uq, user u " +
            "WHERE u.nickname=:nickname AND u.user_id=uq.user_id";

    public static final String RANDOM_GET_QUIZ = "SELECT q.quiz_id, q.content, uq.answer " +
            "FROM quiz q, user_quiz uq " +
            "ORDER BY RAND() limit 5";
}
