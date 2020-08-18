package ac.kr.smu.lookie.quiz.service.user;

import ac.kr.smu.lookie.quiz.dto.user.User;

// UserDbService는 스프링 시큐리티에서 필요로 하는 정보를 가지고 오는 메소드를 가지고 있다.
public interface UserService extends UserDbService {
    public Boolean isValidNickName(String nickname);
    public int insertUser(User user);
}