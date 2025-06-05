package se.iths.webservices.clientservice.controller;

import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Controller
public class QuotesController {

    private final WebClient webClient;

    public QuotesController() {
        this.webClient = WebClient.builder()
                .baseUrl("http://localhost:8080") // Gateway
                .build();
    }

    // Visa sidan "/quotes" utan något citat
    @GetMapping("/quotes")
    public String showQuotesPage() {
        return "quotes";
    }

    // Hämta citat när man klickar 🎲 Random Quote
    @GetMapping("/quotes/random")
    public String getRandomQuote(@RegisteredOAuth2AuthorizedClient OAuth2AuthorizedClient client,
                                 Model model) {
        String quote = null;
        try {
            quote = webClient.get()
                    .uri("/quotes/random")
                    .headers(h -> h.setBearerAuth(client.getAccessToken().getTokenValue()))
                    .retrieve()
                    .bodyToMono(String.class)
                    .block(Duration.ofSeconds(5));

        } catch (Exception e) {
            e.printStackTrace(); // Vi vill se exakt varför citat inte kommer
        }

        model.addAttribute("randomQuote", quote == null ? "🛑 NO QUOTE FETCHED!" : quote);
        return "quotes";
    }
}
