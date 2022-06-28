package com.yokau.fmmall.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CategoryVO {
    /**
     * 主键 分类id主键
     */
    @Id
    @Column(name = "category_id")
    private String categoryId;

    /**
     * 分类名称 分类名称
     */
    @Column(name = "category_name")
    private String categoryName;

    /**
     * 分类层级 分类得类型，
     1:一级大分类
     2:二级分类
     3:三级小分类
     */
    @Column(name = "category_level")
    private Integer categoryLevel;

    /**
     * 父层级id 父id 上一级依赖的id，1级分类则为0，二级三级分别依赖上一级
     */
    @Column(name = "parent_id")
    private Integer parentId;

    /**
     * 图标 logo
     */
    @Column(name = "category_icon")
    private String categoryIcon;

    /**
     * 口号
     */
    @Column(name = "category_slogan")
    private String categorySlogan;

    /**
     * 分类图
     */
    @Column(name = "category_pic")
    private String categoryPic;

    /**
     * 背景颜色
     */
    @Column(name = "category_bg_color")
    private String categoryBgColor;

    /**
     * 实现首页的类别显示
     */
    private List<CategoryVO> categories;

    /**
     * 实现首页分类商品推荐
     */
    private List<ProductVO> products;

}