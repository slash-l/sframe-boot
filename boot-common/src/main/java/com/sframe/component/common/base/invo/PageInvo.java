package com.sframe.component.common.base.invo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author mumu
 * @vervion v1.0
 * @description 分页基础类
 * @date 2017/7/3 2017, 下午10:11
 */
@Data
public class PageInvo implements Serializable {

    /**
     * 每页显示数据条数，默认10条
     */
    private Integer pageSize = 10;

    /**
     * 显示第几页，默认第一页
     */
    private Integer pageNum = 1;

}
