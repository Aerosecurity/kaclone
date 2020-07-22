package com.mycompany.app;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import com.mycompany.app.model.City;
import com.mycompany.app.service.GameService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GameController {
    @Autowired
    private GameService gameService;

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

    @GetMapping(path = "/city", produces = "application/json")
    public ResponseEntity<List<City>> getCitiesForOwner(@RequestParam(value = "ownerId") String ownerId)
    {
        UUID ownerUuid = UUID.fromString(ownerId);
        return ResponseEntity.ok(gameService.listCitiesForOwner(ownerUuid));
    }

    @GetMapping(path = "/city/{id}", produces = "application/json")
    public ResponseEntity<City> getCityByUuid(@PathVariable(value = "id") String id) {
        UUID cityUuid = UUID.fromString(id);
        return ResponseEntity.ok(gameService.getCity(cityUuid));
    }

    @PostMapping(path = "/city", consumes = "application/json", produces = "application/json")
    public ResponseEntity<City> buildCity(@RequestBody CityBuildRequest cityRequest) {
        System.console().printf("Got build request");
        UUID ownerUuid = UUID.fromString(cityRequest.getOwnerId());
        return ResponseEntity.ok(gameService.buildCity(cityRequest.getCityName(), ownerUuid));
    }
}