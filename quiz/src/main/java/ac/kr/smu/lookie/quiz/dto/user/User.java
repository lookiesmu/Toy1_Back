package ac.kr.smu.lookie.quiz.dto.user;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Setter
@Getter
@ToString
public class User {
    private int userId;
    private String nickname;
    private String password;
    private Date quizCreate;
}
