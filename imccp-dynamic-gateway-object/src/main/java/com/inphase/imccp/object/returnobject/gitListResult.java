package com.inphase.imccp.object.returnobject;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Author:xianxiong
 * @Date: Create in 15:39 2019/3/28 0028
 */
@ApiModel(description = "分页查询")
public class gitListResult extends JsonResult{

    @ApiModelProperty(value = "页码",dataType = "Integer")
    private Integer pageNum;

    @ApiModelProperty(value = "页数",dataType = "Integer")
    private Integer pageSize;

    @ApiModelProperty(value = "总条数",dataType = "Integer")
    private Integer total;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
