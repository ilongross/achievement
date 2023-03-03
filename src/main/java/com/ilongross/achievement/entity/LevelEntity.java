package com.ilongross.achievement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "level")
public class LevelEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Integer id;

    @Column(name = "parent_id")
    private Integer parentId;

    @Column(name = "name", length = 50)
    private String name;

    @Column(name = "jump_points")
    private int jumpPoints;

    @Column(name = "scored_points")
    private int scoredPoints;

    @Column(name = "start_tree")
    private boolean startTree;

    @Column(name = "deleted")
    private boolean deleted;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_id")
    private List<LevelEntity> child = new ArrayList<>();

}