package com.sframe.component.common.base.invo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author mumu
 * @vervion v1.0
 * @description 分页基础类
 * @date 2017/7/3 2017, 下午10:11
 */
@ApiModel(value = "查询分页入参")
@Data
public class PageInvo implements Serializable {

    /**
     * 每页显示数据条数，默认10条
     */
    @ApiModelProperty(value = "每页显示记录数")
    private Integer pageSize = 10;

    /**
     * 显示第几页，默认第一页
     */
    @ApiModelProperty(value = "查询页码")
    private Integer pageNum = 1;

}
