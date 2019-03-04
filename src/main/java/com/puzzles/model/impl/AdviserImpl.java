package com.puzzles.model.impl;

import com.puzzles.model.Adviser;
import com.puzzles.model.GameStatus;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class AdviserImpl implements Adviser {

    private Map<GameStatus, List<String>> adviceMap = new HashMap<>();

    {
        adviceMap.put(GameStatus.NEW, Arrays.asList("Welcome on board!", "Happy to see you. Try the luck!"));
        adviceMap.put(GameStatus.COMPLETED, Arrays.asList(
                "Congrats! You have done it!",
                "It was impossible to pass but you did it!",
                "You win, smart guy!",
                "You win! I wish I have done it as fast as you"));
        adviceMap.put(GameStatus.STANDARD_MOD, Arrays.asList(
                "No pain - no game.",
                "Play gard or go home.",
                "As coca cola said : \"Try again\"",
                "Are you going to win with such a tactic?",
                "Do tou think that you are smarter than computer?",
                "You have only one option: win or loose."));
        adviceMap.put(GameStatus.SUPER_HERO_MOD, Arrays.asList(
                "Cheating is not good",
                "Remember, Big Brother is watching you.",
                "Be careful with the magic",
                "Big power - big responsibility"));
    }

    @Override
    public String advise(GameStatus gameStatus) {
        List<String> strings = adviceMap.get(gameStatus);
        Random random = new Random();
        return strings != null ? strings.get(random.nextInt(strings.size())) : "";
    }
}
