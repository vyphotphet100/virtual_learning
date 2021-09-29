package com.webpro.virtual_learning.lowerdao.impl;

import com.webpro.virtual_learning.converter.ResultSetDTOConverter;
import com.webpro.virtual_learning.dto.BaseDTO;
import com.webpro.virtual_learning.lowerdao.IBaseLowerDAO;

import java.sql.*;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.util.ResourceBundle;

public class BaseLowerDAO<T> implements IBaseLowerDAO<T> {
    private ResourceBundle resourceBundle = ResourceBundle.getBundle("db");
    private ResultSetDTOConverter converter = new ResultSetDTOConverter();

    private Connection getConnection() {
        try {
            Class.forName(resourceBundle.getString("driverName"));
            String url = resourceBundle.getString("url");
            String user = resourceBundle.getString("user");
            String password = resourceBundle.getString("password");
            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            return null;
        }
    }

    @Override
    public List<T> query(String sql, Class tClass) {
        List<T> res = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = this.getConnection();
            stm = conn.prepareStatement(sql);
            rs = stm.executeQuery();

            while (rs.next()) {
                BaseDTO dto = converter.toDTO(rs, tClass);
                res.add((T)dto);
            }

            return res;
        } catch (SQLException e1) {
            e1.printStackTrace();
            return null;
        } finally {
            try {
                if (conn != null)
                    conn.close();
                if (stm != null)
                    stm.close();
                if (rs != null)
                    rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    @Override
    public Object insert(String sql, Object... params) {
        Connection conn = this.getConnection();
        PreparedStatement stm = null;
        ResultSet rs = null;
        Object id = null;

        try {
            if (conn != null) {
                conn.setAutoCommit(false);
                stm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                this.setParameters(stm, params);
                stm.executeUpdate();
                rs = stm.getGeneratedKeys();
                if (rs.next())
                    id = rs.getObject(1);

                conn.commit();
                return id;
            }

            return null;
        } catch (SQLException e) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }

            e.printStackTrace();
            return null;
        } finally {
            try {
                if (conn != null)
                    conn.close();
                if (stm != null)
                    stm.close();
                if (rs != null)
                    rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    @Override
    public void delete(String sql, Object... params) {
        Connection conn = this.getConnection();
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            if (conn != null) {
                conn.setAutoCommit(false);
                stm = conn.prepareStatement(sql);
                this.setParameters(stm, params);
                stm.execute();

                conn.commit();
            }
        } catch (SQLException e) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }

            e.printStackTrace();
        } finally {
            try {
                if (conn != null)
                    conn.close();
                if (stm != null)
                    stm.close();
                if (rs != null)
                    rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    private void setParameters(PreparedStatement stm, Object... parameters) {
        for (int i = 0; i < parameters.length; i++) {
            try {
                Object parameter = parameters[i];
                int index = i + 1;

                if (parameter instanceof Long)
                    stm.setLong(index, (Long) parameter);
                else if (parameter instanceof String)
                    stm.setString(index, (String) parameter);
                else if (parameter instanceof Integer)
                    stm.setInt(index, (Integer) parameter);
                else if (parameter instanceof Timestamp)
                    stm.setTimestamp(index, (Timestamp) parameter);
                else if (parameter instanceof Date)
                    stm.setDate(index, (Date) parameter);
                else if (parameter == null)
                    stm.setNull(index, Types.NULL);
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
    }
}
