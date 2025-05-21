package com.ruoyi.system.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.BlogArticle;
import com.ruoyi.system.service.IBlogArticleService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 文章管理Controller
 * 
 * @author ruoyi
 * @date 2025-05-21
 */
@Controller
@RequestMapping("/system/article")
public class BlogArticleController extends BaseController
{
    private String prefix = "system/article";

    @Autowired
    private IBlogArticleService blogArticleService;

    @RequiresPermissions("system:article:view")
    @GetMapping()
    public String article()
    {
        return prefix + "/article";
    }

    /**
     * 查询文章管理列表
     */
    @RequiresPermissions("system:article:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(BlogArticle blogArticle)
    {
        startPage();
        List<BlogArticle> list = blogArticleService.selectBlogArticleList(blogArticle);
        return getDataTable(list);
    }

    /**
     * 导出文章管理列表
     */
    @RequiresPermissions("system:article:export")
    @Log(title = "文章管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(BlogArticle blogArticle)
    {
        List<BlogArticle> list = blogArticleService.selectBlogArticleList(blogArticle);
        ExcelUtil<BlogArticle> util = new ExcelUtil<BlogArticle>(BlogArticle.class);
        return util.exportExcel(list, "文章管理数据");
    }

    /**
     * 新增文章管理
     */
    @RequiresPermissions("system:article:add")
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存文章管理
     */
    @RequiresPermissions("system:article:add")
    @Log(title = "文章管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(BlogArticle blogArticle)
    {
        return toAjax(blogArticleService.insertBlogArticle(blogArticle));
    }

    /**
     * 修改文章管理
     */
    @RequiresPermissions("system:article:edit")
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        BlogArticle blogArticle = blogArticleService.selectBlogArticleById(id);
        mmap.put("blogArticle", blogArticle);
        return prefix + "/edit";
    }

    /**
     * 修改保存文章管理
     */
    @RequiresPermissions("system:article:edit")
    @Log(title = "文章管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(BlogArticle blogArticle)
    {
        return toAjax(blogArticleService.updateBlogArticle(blogArticle));
    }

    /**
     * 删除文章管理
     */
    @RequiresPermissions("system:article:remove")
    @Log(title = "文章管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(blogArticleService.deleteBlogArticleByIds(ids));
    }
}
