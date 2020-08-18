package ac.kr.smu.lookie.quiz.controller;

import ac.kr.smu.lookie.quiz.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/users")
    public Map<String, Boolean> isValidNickName(@RequestParam(name = "nickname") String nickname){
        Map<String, Boolean> resultMap = new HashMap<>();
        boolean isValid = userService.isValidNickName(nickname);

        resultMap.put("success", isValid);
        return resultMap;
    }
}
