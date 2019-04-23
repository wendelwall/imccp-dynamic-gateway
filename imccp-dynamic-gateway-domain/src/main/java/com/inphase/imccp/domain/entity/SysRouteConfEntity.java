package com.inphase.imccp.domain.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

public class SysRouteConfEntity implements Serializable {
    private String id;
    /**
     * 路由ID
     */
    private String routeId;
    /**
     * 断言
     */
    private Object predicates;
    /**
     * 过滤器
     */
    private Object filters;
    /**
     * uri
     */
    private String uri;
    /**
     * 排序
     */
    private Integer orders;
    /**
     * 创建时间
     */
    private Timestamp createTime;
    /**
     * 修改时间
     */
    private Timestamp updateTime;
    /**
     * 删除标识（0-正常,1-删除）
     */
    private String delFlag;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRouteId() {
        return routeId;
    }

    public void setRouteId(String routeId) {
        this.routeId = routeId == null ? null : routeId.trim();
    }

    public Object getPredicates() {
        return predicates;
    }

    public void setPredicates(Object predicates) {
        this.predicates = predicates;
    }

    public Object getFilters() {
        return filters;
    }

    public void setFilters(Object filters) {
        this.filters = filters;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri == null ? null : uri.trim();
    }

    public Integer getOrder() {
        return orders;
    }

    public void setOrder(Integer orders) {
        this.orders = orders;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }
}