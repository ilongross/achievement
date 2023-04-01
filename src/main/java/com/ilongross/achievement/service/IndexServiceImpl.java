package com.ilongross.achievement.service;

import com.ilongross.achievement.dto.LevelDto;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class IndexServiceImpl implements IndexService {

    @Override
    public int defineIndex(LevelDto levelDto) {
        return countParentsByRecursion(0, levelDto.getParentId());
    }

    // TODO: вытягивать всех parents для подсчета индекса и размера структуры
    private int countParentsByRecursion(int counter, Integer parentId) {
        return Objects.isNull(parentId)
                ? counter
                : countParentsByRecursion(++counter, parentId);
    }

}
