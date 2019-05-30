package com.eduwechat.backend.backend.entity.extra;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @program: backend
 * @description: ChemistryEntity
 * @author: Vaskka
 * @create: 2019/5/31 12:55 AM
 **/

@Setter
@Getter
@NoArgsConstructor
@Document(collection = "new_chemistry")
public class ChemistryEntity {

    private String id;

    private String title;

    private String yiji;

    private String content;

    public ChemistryEntity(String id, String title, String yiji, String content) {
        this.id = id;
        this.title = title;
        this.yiji = yiji;
        this.content = content;
    }
}
