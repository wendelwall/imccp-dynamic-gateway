package com.inphase.imccp.object.util;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
/**
 * @Author:xianxiong
 * @Date: Create in 22:51 2019/3/28 0028
 */
public class JsonTypeHandler extends BaseTypeHandler {
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Object parameter,
                                    JdbcType jdbcType) throws SQLException {
        ps.setString(i, JsonUtil.stringify(parameter));
    }

    @Override
    public Object getNullableResult(ResultSet rs, String columnName)
            throws SQLException {
        return JsonUtil.parse(rs.getString(columnName), Object.class);
    }

    @Override
    public Object getNullableResult(CallableStatement cs, int columnIndex)
            throws SQLException {

        return JsonUtil.parse(cs.getString(columnIndex), Object.class);
    }
}
