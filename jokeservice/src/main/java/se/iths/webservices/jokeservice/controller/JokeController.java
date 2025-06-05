package se.iths.webservices.jokeservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@RestController
@RequestMapping("/jokes")
public class JokeController {

    private final List<String> jokes;

    public JokeController() {
        jokes = List.of(
                "What did Sam do when the teacher told him to sing? Samsung.",
                "Doctor: I have your test results. Me: Did I pass? Doctor: No, but you will soon.",
                "Why did Darth Vader go to art school? To learn how to draw... the dark side.",
                "What does Thor use to power his Iphone? ThunderBolt.",
                "Why did Deadpool get kicked out of the movie theater? He wouldn't stop breaking the 4th wall.",
                "What's Loki's favorite type of party? A low-key party.",
                "Why do Java developers wear glasses? Because they don't C#",
                "What has 5 toes but isn't your foot? My foot"
        );
    }

    @GetMapping("/random")
    public String randomJoke() {
        return jokes.get(ThreadLocalRandom.current().nextInt(jokes.size()));
    }
}
