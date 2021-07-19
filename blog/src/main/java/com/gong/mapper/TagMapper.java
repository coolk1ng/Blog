package com.gong.mapper;

import com.github.pagehelper.PageInfo;
import com.gong.pojo.Tag;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by GongXiWu on 2021/05/28
 */
@Mapper
public interface TagMapper {
    //增加标签
    Integer addTag(Tag tag);

    //根据id查询标签
    Tag getTagById(Integer id);

    //根据名称查询标签
    Tag getTagByName(String name);

    //查询所有标签
    List<Tag> getAllTag();

    //分页查询
    PageInfo<Tag> getPage(int pageNum, int pageSize);

    //修改标签
    Integer updateTag(Tag tag);

    //删除标签
    Integer deleteTag(Integer id);
}
