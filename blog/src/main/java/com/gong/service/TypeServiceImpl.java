package com.gong.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gong.mapper.TypeMapper;
import com.gong.pojo.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by GongXiWu on 2021/05/26
 */
@Service("TypeService")
public class TypeServiceImpl implements TypeService{
    @Autowired
    private TypeMapper typeMapper;

    @Override
    public Integer addType(Type type) {
        return typeMapper.addType(type);
    }

    @Override
    public Type getTypeById(Integer id) {
        return typeMapper.getTypeById(id);
    }

    @Override
    public Type getTypeByName(String name) {
        return typeMapper.getTypeByName(name);
    }

    @Override
    public List<Type> getAllType() {
        return typeMapper.getAllType();
    }

    @Override
    public PageInfo<Type> getPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Type> allType = typeMapper.getAllType();
        return new PageInfo<>(allType);
    }

    @Override
    public Integer updateType(Type type) {
        return typeMapper.updateType(type);
    }

    @Override
    public Integer deleteType(Integer id) {
       return typeMapper.deleteType(id);
    }

    @Override
    public List<Type> getAllTypeAndBlog() {
        return typeMapper.getAllTypeAndBlog();
    }
}
