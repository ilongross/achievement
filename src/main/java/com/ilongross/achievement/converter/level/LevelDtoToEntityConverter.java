package com.ilongross.achievement.converter.level;

import com.ilongross.achievement.dto.LevelDto;
import com.ilongross.achievement.entity.LevelEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class LevelDtoToEntityConverter implements Converter<LevelDto, LevelEntity> {
    @Override
    public LevelEntity convert(LevelDto dto) {
        var entity = new LevelEntity();
        entity.setId(dto.getId());

        var child = dto.getChild();
        if (Objects.nonNull(child)) {
            entity.setChild(child.stream()
                    .map(this::convert)
                    .collect(Collectors.toList()));
        }

        BeanUtils.copyProperties(dto, entity);

        return entity;
    }
}
