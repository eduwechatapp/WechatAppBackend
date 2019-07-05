package com.eduwechat.backend.backend.entity.extra;

import com.eduwechat.backend.backend.entity.base.BaseExtraEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@NoArgsConstructor
@Document(collection = "new_biology")
public class BiologyEntity extends BaseExtraEntity {

    private String id;

    private String title;

    private String yiji;

    private String content;

    public BiologyEntity(String id, String title, String yiji, String content) {
        this.id = id;
        this.title = title;
        this.yiji = yiji;
        this.content = content;
    }
}
