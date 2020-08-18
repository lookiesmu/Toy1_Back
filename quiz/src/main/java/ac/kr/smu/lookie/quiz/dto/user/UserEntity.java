package ac.kr.smu.lookie.quiz.dto.user;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
// 로그인 아이디와 암호 정보를 가지는 클래스
public class UserEntity {
    private int userId;
    private String nickname;
    private String password;

    public UserEntity (int userId, String nickname, String password){
        this.userId = userId;
        this.nickname = nickname;
        this.password = password;
    }
}
