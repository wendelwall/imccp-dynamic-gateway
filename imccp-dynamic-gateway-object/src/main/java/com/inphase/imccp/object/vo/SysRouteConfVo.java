package com.inphase.imccp.object.vo;import io.swagger.annotations.ApiModel;import io.swagger.annotations.ApiModelProperty;import java.io.Serializable;/** * @Author:xianxiong * @Date: Create in 21:59 2018/12/25 0025 */@ApiModel(description = "路由配置实体")public class SysRouteConfVo implements Serializable {    @ApiModelProperty(value = "主键id",dataType = "String")    private String id;    @ApiModelProperty(value = "服务名",dataType = "String")    private String routeId;    @ApiModelProperty(value = "断言",dataType = "String")    private String predicates;    @ApiModelProperty(value = "过滤器",dataType = "String")    private String filters;    @ApiModelProperty(value = "转发地址",dataType = "String")    private String uri;    @ApiModelProperty(value = "执行排序",dataType = "Integer")    private int order;    public String getId() {        return id;    }    public void setId(String id) {        this.id = id;    }    public String getRouteId() {        return routeId;    }    public void setRouteId(String routeId) {        this.routeId = routeId;    }    public String getPredicates() {        return predicates;    }    public void setPredicates(String predicates) {        this.predicates = predicates;    }    public String getFilters() {        return filters;    }    public void setFilters(String filters) {        this.filters = filters;    }    public String getUri() {        return uri;    }    public void setUri(String uri) {        this.uri = uri;    }    public int getOrder() {        return order;    }    public void setOrder(int order) {        this.order = order;    }}