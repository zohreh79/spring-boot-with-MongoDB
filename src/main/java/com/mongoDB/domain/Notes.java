package com.mongoDB.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Document(collection = "spring-note")
public class Notes {

    @Id
    @Indexed(useGeneratedName = true)
    private String id;

    private String title;
    private String text;
    private Long timestamp;

    public Notes(String title, String text, Long timestamp) {
        this.title = title;
        this.text = text;
        this.timestamp = timestamp;
    }
}
