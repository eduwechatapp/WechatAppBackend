package com.eduwechat.backend.backend.repository.exercise.aggregation.set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class TotalTitleResultItem {
    private String yiji;

    private List<String> erji;

}
