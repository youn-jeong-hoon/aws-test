package com.example.demo.config;

import com.example.demo.CustomOAuth2UserService;
import com.example.demo.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

// Spring Security 설정 활성화
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {
  private final CustomOAuth2UserService customOAuth2UserService;
  protected void configure(HttpSecurity http) throws Exception {
    http
        .csrf().disable()
        .headers().frameOptions().disable()
        .and()
        .authorizeRequests()
        // 권한 관리 대상 지정 START
        .antMatchers("/", "/css/**", "images/**", "/js/**", "/h2-console/**").permitAll()
        .antMatchers("/api/v1/**").hasRole(Role.USER.name())
        // 권한 관리 대산 지정 END
        // 설정된 값들 이외 나머지 URL
        .anyRequest().authenticated()
        .and()
        .logout().logoutSuccessUrl("/")
        .and()
        .oauth2Login()
        // OAuth2 로그인 성공 이후 사용자 정보를 가져올때의 설정
        .userInfoEndpoint()
        // 소셜 로그인 성공 시 후속 조치를 진행할 UserService 인터페이스의 구현체
        // 리소스 서버(즉, 소셜 서비스들)에서 사용자 정보를 가져온 상태에서 추가로 진행하고자 하는 기능을 명시할 수 있음
        .userService(customOAuth2UserService)
    ;
  }
}
