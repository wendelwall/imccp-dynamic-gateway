package com.inphase.imccp.object.vo;

import java.util.Date;

/**
 * @Author:xianxiong
 * @Date: Create in 16:52 2019/1/3 0003
 */
public class TbRouteVo {
    private String id;

    private String serviceName;

    private String matchAddress;

    private String forwardPath;

    private String isRemovePrefix;

    private String filters;

    private Date createTime;

    private Date updateTime;

    private String isFlag;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getMatchAddress() {
        return matchAddress;
    }

    public void setMatchAddress(String matchAddress) {
        this.matchAddress = matchAddress;
    }

    public String getForwardPath() {
        return forwardPath;
    }

    public void setForwardPath(String forwardPath) {
        this.forwardPath = forwardPath;
    }

    public String getIsRemovePrefix() {
        return isRemovePrefix;
    }

    public void setIsRemovePrefix(String isRemovePrefix) {
        this.isRemovePrefix = isRemovePrefix;
    }

    public String getFilters() {
        return filters;
    }

    public void setFilters(String filters) {
        this.filters = filters;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getIsFlag() {
        return isFlag;
    }

    public void setIsFlag(String isFlag) {
        this.isFlag = isFlag;
    }
}
