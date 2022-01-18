package com.example.demo;

import com.example.demo.auth.LoginUser;
import javax.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
public class LoginController {
  private final HttpSession httpSession;
  //Postsser
  @RequestMapping("/")
  public String login(Model model, @LoginUser SessionUser user) {
    log.info("로그인 페이지");
//    model.addAttribute("posts", postsSer)

    if(user != null) {
      log.info("사용자 정보 존재");
      model.addAttribute("userName", user.getName());
    }

    return "index";
  }

  public String main() {
    return "main";
  }
}
