package com.gong.mapper;

import com.github.pagehelper.PageInfo;
import com.gong.pojo.Blog;
import com.gong.pojo.Type;
import com.gong.vo.DetailedBlog;
import com.gong.vo.FirstPageBlog;
import com.gong.vo.RecommendBlog;
import com.gong.vo.SearchBlog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;


/**
 * Created by GongXiWu on 2021/05/28
 */
@Mapper
public interface BlogMapper {

    //增加博客
    Integer addBlog(Blog blog);

    //根据id查询博客
    Blog getBlogById(Integer id);

    //查询所有博客
    List<Blog> getAllBlog();

    //查询所有博客 (*)
    List<FirstPageBlog> getBlogs();

    //查询推荐博客
    List<RecommendBlog> getAllRecommendBlog();

    //搜索博客
    List<Blog> searchBlog(Blog blog);

    //分页查询博客
    PageInfo<Blog> getPage(int pageNum, int pageSize);

    //更新博客
    Integer updateBlog(Blog blog);

    //前端展示搜索博客
    List<FirstPageBlog> queryBlog(String query);

    //删除博客
    Integer deleteBlog(Integer id);

    //博客详情查询
    DetailedBlog getDetailedBlog(Integer id);

    //分类页面查询博客
    List<FirstPageBlog> getByTypeId(Integer typeId);

    //博客归档
    Map<String,List<Blog>> archivesBlog();

    //分组查询年份
    List<String> getGroupYear();

    //根据年份查询博客
    List<Blog> getByYear(String year);

    //查询博客数目
    Integer getBlogTotal();

}
