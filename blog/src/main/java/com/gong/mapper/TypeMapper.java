package com.gong.mapper;

import com.github.pagehelper.PageInfo;
import com.gong.pojo.Type;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by GongXiWu on 2021/05/26
 */
@Mapper
public interface TypeMapper {

    //增加分类
    Integer addType(Type type);

    //根据id查询分类
    Type getTypeById(Integer id);

    //根据名称查询分类
    Type getTypeByName(String name);

    //查询所有分类
    List<Type> getAllType();

    //分页查询
    PageInfo<Type> getPage(int pageNum,int pageSize);

    //修改分类
    Integer updateType(Type type);

    //删除分类
    Integer deleteType(Integer id);

    //分类页面查询
    List<Type> getAllTypeAndBlog();

}
