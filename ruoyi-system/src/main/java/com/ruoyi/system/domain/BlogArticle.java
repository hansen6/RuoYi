package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 文章管理对象 blog_article
 * 
 * @author ruoyi
 * @date 2025-05-21
 */
public class BlogArticle extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 文章标题 */
    @Excel(name = "文章标题")
    private String title;

    /** 文章内容 */
    @Excel(name = "文章内容")
    private String content;

    /** 摘要 */
    @Excel(name = "摘要")
    private String summary;

    /** 封面图片 */
    @Excel(name = "封面图片")
    private String coverImage;

    /** 分类ID */
    @Excel(name = "分类ID")
    private Long categoryId;

    /** 状态 0草稿 1发布 2置顶 */
    @Excel(name = "状态 0草稿 1发布 2置顶")
    private Integer status;

    /** 作者ID */
    @Excel(name = "作者ID")
    private Long authorId;

    /** 浏览量 */
    @Excel(name = "浏览量")
    private Long viewCount;

    /** 评论数 */
    @Excel(name = "评论数")
    private Long commentCount;

    /** 逻辑删除 */
    @Excel(name = "逻辑删除")
    private Integer isDeleted;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }

    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }

    public void setSummary(String summary) 
    {
        this.summary = summary;
    }

    public String getSummary() 
    {
        return summary;
    }

    public void setCoverImage(String coverImage) 
    {
        this.coverImage = coverImage;
    }

    public String getCoverImage() 
    {
        return coverImage;
    }

    public void setCategoryId(Long categoryId) 
    {
        this.categoryId = categoryId;
    }

    public Long getCategoryId() 
    {
        return categoryId;
    }

    public void setStatus(Integer status) 
    {
        this.status = status;
    }

    public Integer getStatus() 
    {
        return status;
    }

    public void setAuthorId(Long authorId) 
    {
        this.authorId = authorId;
    }

    public Long getAuthorId() 
    {
        return authorId;
    }

    public void setViewCount(Long viewCount) 
    {
        this.viewCount = viewCount;
    }

    public Long getViewCount() 
    {
        return viewCount;
    }

    public void setCommentCount(Long commentCount) 
    {
        this.commentCount = commentCount;
    }

    public Long getCommentCount() 
    {
        return commentCount;
    }

    public void setIsDeleted(Integer isDeleted) 
    {
        this.isDeleted = isDeleted;
    }

    public Integer getIsDeleted() 
    {
        return isDeleted;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("title", getTitle())
            .append("content", getContent())
            .append("summary", getSummary())
            .append("coverImage", getCoverImage())
            .append("categoryId", getCategoryId())
            .append("status", getStatus())
            .append("authorId", getAuthorId())
            .append("viewCount", getViewCount())
            .append("commentCount", getCommentCount())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("isDeleted", getIsDeleted())
            .toString();
    }
}
