package com.inphase.imccp.domain.dao;

import com.inphase.imccp.domain.entity.SysRouteConfEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysRouteConfMapper {

    List<SysRouteConfEntity> getList(@Param("pageNum")Integer pageNum, @Param("pageSize")Integer pageSize);

    void add(SysRouteConfEntity sysRouteConfEntity);

    void deleteById(@Param("id") String id);

    void update(SysRouteConfEntity sysRouteConfEntity);

    List<SysRouteConfEntity> getAll();
}