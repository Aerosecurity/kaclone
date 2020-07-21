package com.mycompany.app;

import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GameController {
    @GetMapping("/game")
    public String gamePage(@CookieValue(value = "userId", defaultValue = "") String userId, 
                            Model model, 
                            HttpServletResponse response) {
        UUID userUuid;
        try {
            userUuid = UUID.fromString(userId);
        }
        catch (IllegalArgumentException e) {
            userUuid = UUID.randomUUID();
            Cookie cookie = new Cookie("userId", userUuid.toString());
            response.addCookie(cookie);
        }

        model.addAttribute("userId", userUuid.toString());

        return "game";
    }
}