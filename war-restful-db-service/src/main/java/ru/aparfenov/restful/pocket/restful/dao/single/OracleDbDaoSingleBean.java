package ru.aparfenov.restful.pocket.restful.dao.single;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;

@Stateless
public class OracleDbDaoSingleBean implements DbDaoSingle {
    @Resource(name="jdbc/myOracleDataSource")
    private DataSource myDs;
    private Connection conn;

    public OracleDbDaoSingleBean() {
    }

    @PostConstruct
    private void init() {
    }

    @Override
    public String executeQuery(String sqlQuery) {
        StringBuilder result = new StringBuilder();
        try {
            this.conn = myDs.getConnection();
            Locale.setDefault(Locale.ENGLISH);
            this.conn = myDs.getConnection();
            Statement ps = conn.createStatement();
            ResultSet rs = ps.executeQuery(sqlQuery);
            while (rs.next()) {
                result.append(rs.getString(1));
            }
        } catch (SQLException e) {
            result.append("SQL exception while executing the query");
            result.append(e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                result.append("SQL exception while trying to close the connection");
                result.append(e.getMessage());
                e.printStackTrace();
            }
        }
        return "query:" + sqlQuery + ":\n" + result.toString();
    }

    @Override
    public boolean executeUpdate(String sqlQuery) {
        return false;
    }
}
