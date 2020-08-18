package ac.kr.smu.lookie.quiz.dto.user;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Setter
@Getter
@ToString
// 데이터베이스에서 읽어들인 로그인 정보는 UserDetails 인터페이스를 구현하고 있는 객체에 저장되어야한다.
public class CustomUserDetails implements UserDetails {
    private String username;
    private String password;
    private boolean isEnabled;
    private boolean isAccountNonExpired;
    private boolean isAccountNonLocked;
    private boolean isCredentialsNonExpired;
    private Collection<? extends GrantedAuthority> authorities;
}