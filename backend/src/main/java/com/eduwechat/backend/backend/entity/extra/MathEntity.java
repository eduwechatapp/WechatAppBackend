package com.eduwechat.backend.backend.entity.extra;

import com.eduwechat.backend.backend.entity.base.BaseExtraEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @program: backend
 * @description: MathEntity
 * @author: Vaskka
 * @create: 2019/5/31 4:01 AM
 **/
@Setter
@Getter
@NoArgsConstructor
@Document(collection = "new_math")
public class MathEntity extends BaseExtraEntity {
    private String id;

    private String title;

    private String yiji;

    private String content;

    public  MathEntity(String id, String title, String yiji, String content) {
        this.id = id;
        this.title = title;
        this.yiji = yiji;
        this.content = content;
    }


}
