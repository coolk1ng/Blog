package com.gong.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.gong.NotFoundException;
import com.gong.Until.MarkdownUtils;
import com.gong.mapper.BlogMapper;
import com.gong.pojo.Blog;
import com.gong.vo.DetailedBlog;
import com.gong.vo.FirstPageBlog;
import com.gong.vo.RecommendBlog;
import com.gong.vo.SearchBlog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by GongXiWu on 2021/05/28
 */
@Service("BlogService")
public class BlogServiceImpl implements BlogService{

    @Autowired
    private BlogMapper blogMapper;

    @Override
    public Integer addBlog(Blog blog) {
        if (blog.getId()==null){
            blog.setUpdateTime(new Date());
            blog.setCreateTime(new Date());
            blog.setViews(0);
        }else{
            blog.setUpdateTime(new Date());
        }
        return blogMapper.addBlog(blog);
    }

    @Override
    public Blog getBlogById(Integer id) {
        return blogMapper.getBlogById(id);
    }


    @Override
    public List<Blog> getAllBlog() {
        return blogMapper.getAllBlog();
    }

    @Override
    public List<FirstPageBlog> getBlogs() {
        return blogMapper.getBlogs();
    }


    @Override
    public List<Blog> searchBlog(Blog blog) {
        return blogMapper.searchBlog(blog);
    }


    @Override
    public PageInfo<Blog> getPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Blog> allBlog = blogMapper.getAllBlog();
        return new PageInfo<>(allBlog);
    }

    @Override
    public PageInfo<FirstPageBlog> getFirstPage(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<FirstPageBlog> firstBlog = blogMapper.getBlogs();
        return new PageInfo<>(firstBlog);
    }

    @Override
    public Integer updateBlog(Blog blog) {
        blog.setUpdateTime(new Date());
        blog.setCreateTime(new Date());
        return blogMapper.updateBlog(blog);
    }

    @Override
    public Integer deleteBlog(Integer id) {
        return blogMapper.deleteBlog(id);
    }

    @Override
    public List<RecommendBlog> getAllRecommendBlog() {
        return blogMapper.getAllRecommendBlog();
    }

    @Override
    public List<FirstPageBlog> queryBlog(String query) {
        return blogMapper.queryBlog(query);
    }

    @Override
    public DetailedBlog getDetailedBlog(Integer id) {
        DetailedBlog blog = blogMapper.getDetailedBlog(id);
        if (blog == null) {
            throw new NotFoundException("该博客不存在");
        }
        String content = blog.getContent();
        blog.setContent(MarkdownUtils.markdownToHtmlExtensions(content));
        return blog;
    }

    @Override
    public List<FirstPageBlog> getByTypeId(Integer typeId) {
        return blogMapper.getByTypeId(typeId);
    }

    @Override
    public Map<String,List<Blog>> archivesBlog() {
        HashMap<String, List<Blog>> map = new HashMap<>();
        List<String> years = blogMapper.getGroupYear();
        for (String year : years) {
            map.put(year,blogMapper.getByYear(year));
        }
        return map;
    }

    @Override
    public List<String> getGroupYear() {
        return blogMapper.getGroupYear();
    }

    @Override
    public List<Blog> getByYear(String year) {
        return blogMapper.getByYear(year);
    }

    @Override
    public Integer getBlogTotal() {
        return blogMapper.getBlogTotal();
    }
}
