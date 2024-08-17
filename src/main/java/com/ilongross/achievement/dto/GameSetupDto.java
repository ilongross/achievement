package com.ilongross.achievement.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Random;

@Getter
@Setter
public class GameSetupDto implements Serializable {

    private final long id = new Random().nextLong(Long.MAX_VALUE);

}
