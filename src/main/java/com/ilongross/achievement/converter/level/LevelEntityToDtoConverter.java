package com.ilongross.achievement.converter.level;

import com.ilongross.achievement.dto.LevelDto;
import com.ilongross.achievement.entity.LevelEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Collectors;


@Component
public class LevelEntityToDtoConverter implements Converter<LevelEntity, LevelDto> {
    @Override
    public LevelDto convert(LevelEntity entity) {
        var dto = new LevelDto();
//        dto.setId(entity.getId());
//        dto.setParentId(entity.getParentId());
        dto.setChild(new ArrayList<>());

//        var child = entity.getChild();
//        if (Objects.nonNull(child)) {
//            dto.setChild(child.stream()
//                    .map(this::convert)
//                    .collect(Collectors.toList()));
//        }

//        BeanUtils.copyProperties(entity, dto);

        return new LevelDto();
    }
}
