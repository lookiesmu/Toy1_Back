package ac.kr.smu.lookie.quiz.controller;

import ac.kr.smu.lookie.quiz.dao.user.UserDao;
import ac.kr.smu.lookie.quiz.dto.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class test {
    @Autowired
    UserDao userDao;

    @GetMapping("/")
    public User test(){
        User user = userDao.selectUserByNickname("길민호");
        return user;
    }
}
