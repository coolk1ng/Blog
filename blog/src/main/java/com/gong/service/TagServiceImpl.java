package com.gong.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gong.mapper.TagMapper;
import com.gong.pojo.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by GongXiWu on 2021/05/28
 */
@Service("TagService")
public class TagServiceImpl implements TagService{

    @Autowired
    private TagMapper tagMapper;

    @Override
    public Integer addTag(Tag tag) {
        return tagMapper.addTag(tag);
    }

    @Override
    public Tag getTagById(Integer id) {
        return tagMapper.getTagById(id);
    }

    @Override
    public Tag getTagByName(String name) {
        return tagMapper.getTagByName(name);
    }

    @Override
    public List<Tag> getAllTag() {
        return tagMapper.getAllTag();
    }

    @Override
    public PageInfo<Tag> getPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Tag> allTag = tagMapper.getAllTag();
        return new PageInfo<>(allTag);
    }

    @Override
    public Integer updateTag(Tag tag) {
        return tagMapper.updateTag(tag);
    }

    @Override
    public Integer deleteTag(Integer id) {
        return tagMapper.deleteTag(id);
    }
}
