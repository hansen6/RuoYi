package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.BlogArticleMapper;
import com.ruoyi.system.domain.BlogArticle;
import com.ruoyi.system.service.IBlogArticleService;
import com.ruoyi.common.core.text.Convert;

/**
 * 文章管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-05-21
 */
@Service
public class BlogArticleServiceImpl implements IBlogArticleService 
{
    @Autowired
    private BlogArticleMapper blogArticleMapper;

    /**
     * 查询文章管理
     * 
     * @param id 文章管理主键
     * @return 文章管理
     */
    @Override
    public BlogArticle selectBlogArticleById(Long id)
    {
        return blogArticleMapper.selectBlogArticleById(id);
    }

    /**
     * 查询文章管理列表
     * 
     * @param blogArticle 文章管理
     * @return 文章管理
     */
    @Override
    public List<BlogArticle> selectBlogArticleList(BlogArticle blogArticle)
    {
        return blogArticleMapper.selectBlogArticleList(blogArticle);
    }

    /**
     * 新增文章管理
     * 
     * @param blogArticle 文章管理
     * @return 结果
     */
    @Override
    public int insertBlogArticle(BlogArticle blogArticle)
    {
        blogArticle.setCreateTime(DateUtils.getNowDate());
        return blogArticleMapper.insertBlogArticle(blogArticle);
    }

    /**
     * 修改文章管理
     * 
     * @param blogArticle 文章管理
     * @return 结果
     */
    @Override
    public int updateBlogArticle(BlogArticle blogArticle)
    {
        blogArticle.setUpdateTime(DateUtils.getNowDate());
        return blogArticleMapper.updateBlogArticle(blogArticle);
    }

    /**
     * 批量删除文章管理
     * 
     * @param ids 需要删除的文章管理主键
     * @return 结果
     */
    @Override
    public int deleteBlogArticleByIds(String ids)
    {
        return blogArticleMapper.deleteBlogArticleByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除文章管理信息
     * 
     * @param id 文章管理主键
     * @return 结果
     */
    @Override
    public int deleteBlogArticleById(Long id)
    {
        return blogArticleMapper.deleteBlogArticleById(id);
    }
}
