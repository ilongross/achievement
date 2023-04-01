package com.ilongross.achievement.service;

import com.ilongross.achievement.dto.LevelDto;
import com.ilongross.achievement.entity.LevelEntity;
import com.ilongross.achievement.repository.LevelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class LevelServiceImpl implements LevelService {

    private final LevelRepository levelRepository;
    private final ConversionService conversionService;

    @Override
    public List<Integer> getIds() {
        return levelRepository.findAllByDeletedIsFalse().stream()
                .map(LevelEntity::getId)
                .sorted(Comparator.comparing(Function.identity()))
                .toList();
    }

    @Override
    public LevelDto get(int id) {
        var entity = levelRepository
                .findByIdAndDeletedIsFalse(id)
                .orElseThrow(() -> new IllegalArgumentException("Уровня с таким ID не существует!"));

        return conversionService.convert(entity, LevelDto.class);
    }

    @Override
    public LevelDto create(LevelDto levelDto) {
        var mapped = conversionService.convert(levelDto, LevelEntity.class);
        var saved = levelRepository.save(Objects.requireNonNull(mapped));

        return conversionService.convert(saved, LevelDto.class);
    }

    @Override
    @Transactional
    public LevelDto update(int id, LevelDto levelDto) {
        var dto = get(id);
        levelDto.setId(dto.getId());
        var mapped = conversionService.convert(levelDto, LevelEntity.class);
        var saved = levelRepository.save(Objects.requireNonNull(mapped));

        return conversionService.convert(saved, LevelDto.class);
    }

    @Override
    @Transactional
    public void delete(int id) {
        var entity = levelRepository.findByIdAndDeletedIsFalse(id)
                .orElseThrow(() -> new IllegalArgumentException("Уровня с таким ID не существует!"));

        var parentOptional = levelRepository.findByIdAndDeletedIsFalse(
                Objects.nonNull(entity.getParentId())
                        ? entity.getParentId()
                        : 0);

        var childList = entity.getChild();
        var childOptional = levelRepository.findByIdAndDeletedIsFalse(
                CollectionUtils.isEmpty(childList)
                        ? 0
                        : entity.getChild().get(0).getId());

        if (parentOptional.isPresent() && childOptional.isPresent()) {
            var child = childOptional.get();
            var parent = parentOptional.get();
            child.setParentId(parent.getId());
            parent.setChild(new ArrayList<>());
            parent.getChild().add(child);

            levelRepository.save(parent);

        } else if (childOptional.isPresent()) {
            var child = childOptional.get();
            child.setParentId(null);

            levelRepository.save(child);
        }

        entity.setDeleted(true);
        levelRepository.save(entity);
    }

    @Override
    public LevelDto structure(int id) {
        return null;
    }
}
