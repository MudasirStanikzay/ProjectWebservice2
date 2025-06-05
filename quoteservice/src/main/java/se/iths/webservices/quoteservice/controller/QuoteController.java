package se.iths.webservices.quoteservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@RestController
@RequestMapping("/quotes")
public class QuoteController {

    private final List<String> quotes = List.of(
            "The hardest choices require the strongest wills. - Thanos",
            "I can do this all day. - Captain America",
            "I choose to run toward my problems, and not away from them. Because that's what heroes do. - Thor",
            "You either die a hero, or you live long enough to see yourself become the villain. - Harvey Dent",
            "With great power comes great responsibility. - Spider-Man",
            "The first rule of Fight Club is: You do not talk about Fight Club. - Tyler Durden",
            "You have to leave something behind to go forward. - Cooper",
            "Maybe someones don't like me but maybe because I'm too good idk why. - Ronaldo 2007"
    );

    @GetMapping("/random")
    public String randomQuote() {
        return quotes.get(ThreadLocalRandom.current().nextInt(quotes.size()));
    }
}

