package com.example.ElasticDemo.search;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class SearchRequestDTO {

    @Getter@Setter
    private List<String> fields;

    @Getter@Setter
    private String searchTerm;
}
