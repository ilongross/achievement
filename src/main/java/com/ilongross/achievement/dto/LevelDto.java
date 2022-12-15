package com.ilongross.achievement.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonFormat
public class LevelDto implements Serializable {

    @JsonProperty
    private int id;
    @JsonProperty
    private Integer parentId;
    @JsonProperty
    private String name;
    @JsonProperty
    private int jumpPoints;
    @JsonProperty
    private int scoredPoints;
    @JsonProperty
    private boolean startTree;
    @JsonProperty
    private boolean deleted;
    @JsonProperty
    private List<LevelDto> child;

}
