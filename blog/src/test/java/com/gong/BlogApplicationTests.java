package com.gong;

import com.github.pagehelper.PageInfo;
import com.gong.pojo.Blog;
import com.gong.pojo.Tag;
import com.gong.pojo.Type;

import com.gong.service.BlogService;
import com.gong.service.TagService;
import com.gong.service.TypeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

import java.util.List;
import java.util.Map;

@SpringBootTest
class BlogApplicationTests {

    @Autowired
    DataSource dataSource;
    @Autowired
    TypeService typeService;
    @Autowired
    TagService tagService;

    @Autowired
    BlogService blogService;
    @Test
    void contextLoads() throws SQLException {
        Connection connection = dataSource.getConnection();
        System.out.println(connection);

    }

    @Test
    void deleteType(){
        int i = typeService.deleteType(1);
        System.out.println(i);
    }

    @Test
    void getTypeById(){
        Type typeById = typeService.getTypeById(2);
        System.out.println(typeById);
    }


    @Test
    void getAllType(){
        List<Type> allType = typeService.getAllType();
        System.out.println(allType);
    }

    @Test
    void getPage(){
        PageInfo<Type> page = typeService.getPage(2,10);
        System.out.println(page);
    }

    @Test
    void getPage1(){
        PageInfo<Tag> page = tagService.getPage(1, 5);
        System.out.println(page.getList());
    }

    @Test
    void archives(){
        List<Blog> byYear = blogService.getByYear("2021");
        List<String> groupYear = blogService.getGroupYear();
        System.out.println(groupYear);
        System.out.println(byYear);
    }

}
