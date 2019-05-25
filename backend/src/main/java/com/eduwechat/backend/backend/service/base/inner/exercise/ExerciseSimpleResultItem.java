package com.eduwechat.backend.backend.service.base.inner.exercise;

import com.eduwechat.backend.backend.entity.base.BaseExerciseEntity;
import com.eduwechat.backend.backend.utils.CommonUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: backend
 * @description: ExerciseSimpleResultItem
 * @author: Vaskka
 * @create: 2019/5/22 12:38 AM
 **/
@Getter
@Setter
@ToString
@AllArgsConstructor
public class ExerciseSimpleResultItem {
    private String id;

    private String content;

    /**
     * 从ExerciseEntity获得返回集结果
     * @param entities 实体对象
     * @return List&lt;ExerciseSimpleResultItem&gt;
     */
    public static List<ExerciseSimpleResultItem> fromEntityGetResultItem(Boolean shrink, List<BaseExerciseEntity> entities) {
        List<ExerciseSimpleResultItem> res = new ArrayList<>(entities.size());
        for (BaseExerciseEntity entity : entities) {

            String content = entity.getContent();
            if (shrink) {
                // 剔除标签和保留前几个字符
                String middle = CommonUtil.fromMarkedGetPureText(content);
                if (middle.length() <= 11) {
                    content = middle;
                } else {
                    content = middle.substring(0, 11) + "...";
                }

            }

            ExerciseSimpleResultItem item = new ExerciseSimpleResultItem(entity.getId(), content);
            res.add(item);
        }

        return res;
    }
}
