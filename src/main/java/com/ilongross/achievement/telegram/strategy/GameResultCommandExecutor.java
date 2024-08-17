package com.ilongross.achievement.telegram.strategy;

import com.ilongross.achievement.mocks.MockService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GameResultCommandExecutor implements BotCommandExecutor {

    private final MockService mockService;

    @Override
    public BotCommandType getType() {
        return BotCommandType.GAME_RESULT;
    }

    @Override
    public String commandName() {
        return "/command1";
    }

    @Override
    public String getResult(Long gameId) {
        return "Победа со счетом 8:6. 23/05/2023";
    }
}
