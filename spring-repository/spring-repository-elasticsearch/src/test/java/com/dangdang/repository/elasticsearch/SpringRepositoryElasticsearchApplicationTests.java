package com.dangdang.repository.elasticsearch;

import org.elasticsearch.cluster.metadata.AliasMetaData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringRepositoryElasticsearchApplicationTests {

    @Test
    public void contextLoads() {
    }


    //@Autowired
    //private UserServiceImpl userService;

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;


    @Test
    public void testUser(){

        /*UserModel userModel = new UserModel();
        userModel.setId(100L);
        userModel.setName("tianjiaqin");
        userModel.setBirth(new Date());
        userModel.setTag("IT");
        userService.save(userModel);*/
        //SearchQuery searchQuery = new NativeSearchQueryBuilder().withQuery(new QueryStringQueryBuilder("1")).build();
        //List<UserModel> articles = elasticsearchTemplate.queryForList(searchQuery, UserModel.class);
        List<AliasMetaData> person = elasticsearchTemplate.queryForAlias("person");
        System.out.println(person);
    }


}

