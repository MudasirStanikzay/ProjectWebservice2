package se.iths.webservices.clientservice.controller;

import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(@RegisteredOAuth2AuthorizedClient OAuth2AuthorizedClient client,
                       Model model) {

        String userName = client.getPrincipalName();
        var tokenScopes = client.getAccessToken().getScopes();
        String tokenValue = client.getAccessToken().getTokenValue();

        model.addAttribute("userName", userName);
        model.addAttribute("tokenScopes", tokenScopes);
        model.addAttribute("tokenValue", tokenValue);

        return "home";
    }
}
