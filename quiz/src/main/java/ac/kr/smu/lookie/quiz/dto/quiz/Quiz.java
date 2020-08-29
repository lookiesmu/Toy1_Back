package ac.kr.smu.lookie.quiz.dto.quiz;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class Quiz {
    private int quizId;
    private String content;
    private int answer;
}
