package com.eduwechat.backend.backend.service.base.inner.exercise;

import com.eduwechat.backend.backend.entity.base.BaseExerciseEntity;
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
public class ExerciseDetailResultItem extends ExerciseBaseResultItem {


    private String type;

    private String content;

    private List<String> choose;

    private String answer;

    private String analysis;

    public ExerciseDetailResultItem(Integer id, String type, String content, List<String> choose, String answer, String analysis) {
        super(id);
        this.analysis = analysis;
        this.answer = answer;
        this.choose = choose;
        this.content = content;
        this.type = type;
    }

    public static ExerciseDetailResultItem fromEntityGetDetailItem(BaseExerciseEntity entity) {
        Integer id = entity.getId();

        String type;

        List<String> choose = new ArrayList<>();

        // 根据content是否包含table标签判断是否是选择题
        if (!entity.getContent().contains("<table>")) {
            type = "非选择题";
        }
        else {
            type = "选择题";

            // xpath提取选项

            HtmlCleaner hc = new HtmlCleaner();
            TagNode tn = hc.clean(entity.getContent());

            // 待验证
            String xpath = "//table/tr/td";

            try {
                Object[] objects = tn.evaluateXPath(xpath);

                for (Object o : objects) {
                    choose.add(o.toString());
                }
            } catch (XPatherException e) {
                e.printStackTrace();
            }
        }


    }
}
