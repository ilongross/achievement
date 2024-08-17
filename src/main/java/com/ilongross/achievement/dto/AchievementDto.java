package com.ilongross.achievement.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class AchievementDto implements Serializable {

    private String name;
    private String description;

}
