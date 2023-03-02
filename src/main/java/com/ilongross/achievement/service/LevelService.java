package com.ilongross.achievement.service;

import com.ilongross.achievement.dto.LevelDto;

import java.util.List;

public interface LevelService {

    List<Integer> getIds();

    LevelDto get(int id);

    LevelDto create(LevelDto levelDto);

    LevelDto update(int id, LevelDto levelDto);

    void delete(int id);

    LevelDto structure(int id);
}
