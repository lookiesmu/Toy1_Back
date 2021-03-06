package ac.kr.smu.lookie.quiz.controller;

import ac.kr.smu.lookie.quiz.dto.Score;
import ac.kr.smu.lookie.quiz.dto.user.User;
import ac.kr.smu.lookie.quiz.service.score.ScoreService;
import ac.kr.smu.lookie.quiz.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    ScoreService scoreService;

    @GetMapping
    public Map<String, Boolean> isValidNickName(@RequestParam(name = "nickname") String nickname){
        Map<String, Boolean> resultMap = new HashMap<>();
        boolean isValid = userService.isValidNickName(nickname);    // nickname 중복 검사

        resultMap.put("success", isValid);  // 중복이면 false, 중복되지 않으면 true 반환
        return resultMap;
    }

    @PostMapping
    public Map<String, Boolean> signUp(@RequestBody User user){
        Map<String, Boolean> resultMap = new HashMap<>();
        String nickname = user.getNickname();
        String password = user.getPassword();

        boolean isValid = userService.isValidNickName(nickname);    // 아이디 중복 검사

        if(isValid){    // 아이디가 중복되지 않은 경우
            try{
                BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
                String encodedPwd = encoder.encode(password);

                user.setPassword(encodedPwd);
                userService.insertUser(user);

                resultMap.put("success", true);
            }catch(Exception e){    // insert 작업 중 에러가 발생한 경우
                e.printStackTrace();
                resultMap.put("success", false);
            }
        }else{  // 아이디가 중복되는 경우
            resultMap.put("success", false);
        }

        return resultMap;
    }

    @PatchMapping
    public Map<String, Boolean> updateNickname(@RequestParam(name = "nickname") String nickname, @RequestParam(name = "newNickname") String newNickname){
        Map<String, Boolean> resultMap = new HashMap<>();
        int updateCount = userService.updateNickname(nickname, newNickname);

        if(updateCount == 0){
            resultMap.put("success", false);
        }else{
            resultMap.put("success", true);
        }

        return resultMap;
    }

    @DeleteMapping
    public Map<String, Boolean> deleteUser(@RequestParam(name = "nickname") String nickname){
        Map<String, Boolean> resultMap = new HashMap<>();
        int deleteCount = userService.deleteUserByNickname(nickname);

        if(deleteCount == 0){
            resultMap.put("success", false);
        }else{
            resultMap.put("success", true);
        }

        return resultMap;
    }

    @GetMapping("/rank")
    public Map<String, Object> getRankByExaminer(@RequestParam(name="examiner") String examiner){
        Map<String, Object>  resultMap = new HashMap<>();

        List<Score> ranking = scoreService.selectScoreByExaminer(examiner);

        resultMap.put("ranking", ranking);
        return resultMap;
    }
}
