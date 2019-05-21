package com.eduwechat.backend.backend.service.base.inner.exercise;

import com.eduwechat.backend.backend.entity.base.BaseExerciseEntity;
import com.eduwechat.backend.backend.entity.exercise.*;
import com.eduwechat.backend.backend.exceptions.exercise.ExerciseIdDoesNotExistException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.TagNode;
import org.htmlcleaner.XPatherException;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class ExerciseDetailResultItem {

    private Integer id;

    private String type;

    private String content;

    private List<String> choose;

    private String answer;

    private String analysis;

    public static ExerciseDetailResultItem fromEntityGetBiologyDetailItem(BiologyExerciseEntity entity) {
        return null;
    }

    public static ExerciseDetailResultItem fromEntityGetChemistryDetailItem(ChemistryExerciseEntity entity) {
        return null;
    }

    public static ExerciseDetailResultItem fromEntityGetChineseDetailItem(ChineseExerciseEntity entity) {
        return null;
    }

    public static ExerciseDetailResultItem fromEntityGetEnglishDetailItem(EnglishExerciseEntity entity) {
        return null;
    }

    public static ExerciseDetailResultItem fromEntityGetGeographyDetailItem(GeographyExerciseEntity entity) {
        return null;
    }

    public static ExerciseDetailResultItem fromEntityGetHistoryDetailItem(HistoryExerciseEntity entity) {
        return null;
    }

    public static ExerciseDetailResultItem fromEntityGetMathDetailItem(MathExerciseEntity entity) {
        return null;
    }

    public static ExerciseDetailResultItem fromEntityGetPhysicsDetailItem(PhysicsExerciseEntity entity) {
        return null;
    }

    public static ExerciseDetailResultItem fromEntityGetPoliticsDetailItem(PoliticsExerciseEntity entity) {
        return null;
    }

}
