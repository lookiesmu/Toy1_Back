package ac.kr.smu.lookie.quiz.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Score {
    private int userId;
    private String nickname;
    private int quizCreate;
    private int score;
}
