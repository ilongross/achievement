package com.ilongross.achievement.repository;

import com.ilongross.achievement.entity.LevelEntity;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LevelRepository {

    List<LevelEntity> findAllByDeletedIsFalse();

    Optional<LevelEntity> findByIdAndDeletedIsFalse(int id);

}
