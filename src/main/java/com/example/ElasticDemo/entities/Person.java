package com.example.ElasticDemo.entities;

import com.example.ElasticDemo.helper.Indices;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Setting;

@Document(indexName = Indices.PERSON_INDEX)
@Setting(settingPath = "static/es-settings.json")
public class Person {

    @Id
    @Getter @Setter
    @Field(type = FieldType.Keyword)
    private String id;

    @Getter @Setter
    @Field(type = FieldType.Text)
    private String name;
}
