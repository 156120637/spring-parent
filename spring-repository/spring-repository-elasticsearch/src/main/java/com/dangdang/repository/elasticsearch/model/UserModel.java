package com.dangdang.repository.elasticsearch.model;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Date;

/**
 * Create by tianjiaqin 2018-12-18
 */
@Data
@Document(indexName = "person", type = "user")
public class UserModel {

    private Long id;
    private String name;
    private Date birth;
    private String tag;
}
