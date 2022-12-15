package com.ilongross.achievement.controller;

import com.ilongross.achievement.dto.LevelDto;
import com.ilongross.achievement.service.LevelService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/level")
@RequiredArgsConstructor
public class LevelController {

    private final LevelService levelService;

    @GetMapping("/list_id")
    public List<Integer> getIds() {
        return levelService.getIds();
    }

    @GetMapping("/{id}")
    public LevelDto get(@PathVariable int id) {
        return levelService.get(id);
    }

    @PutMapping("/create")
    public LevelDto create(@RequestBody LevelDto levelDto) {
        return levelService.create(levelDto);
    }

    @PostMapping("/{id}")
    public LevelDto update(@PathVariable int id, @RequestBody LevelDto levelDto) {
        return levelService.update(id, levelDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        levelService.delete(id);
    }
}
